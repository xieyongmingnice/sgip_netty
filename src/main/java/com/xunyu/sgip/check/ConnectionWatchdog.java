package com.xunyu.sgip.check;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * 自定义一个ConnectionWatchdog（连接监视处理类）
 */

@ChannelHandler.Sharable //表示可以被多个通道（线程安全）的共享
public abstract class ConnectionWatchdog extends ChannelInboundHandlerAdapter implements TimerTask, ChannelHandlerHolder {

    private final Bootstrap bootstrap;
    private final Timer timer;
    private final int port;
    private final String host;
    private volatile boolean reconnect = true;
    private int attempts;


    public ConnectionWatchdog(Bootstrap bootstrap, Timer timer, int port, String host, boolean reconnect) {
        this.bootstrap = bootstrap;
        this.timer = timer;
        this.port = port;
        this.host = host;
        this.reconnect = reconnect;
    }

    /**
     * channel链路每次active的时候，将其连接的次数重新☞ 0
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("当前链路已经激活了，重连尝试次数重新置为0");
        attempts = 0;
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("链接关闭");
        if (reconnect) {
            System.out.println("链接关闭，将进行重连 " + attempts);
            if (attempts < 12) {//重连的间隔时间会越来越长
                attempts++;


                int timeout = 2 << attempts;
                timer.newTimeout(this, timeout, TimeUnit.MILLISECONDS);

                ctx.fireChannelInactive();
            } else {
                System.out.println("我（客户端）不在连了。。。");
                ctx.close();
            }
        }
    }

    /**
     * @param timeout
     * @throws Exception
     * @author dth
     * TimerTask接口中的方法
     */
    public void run(Timeout timeout) throws Exception {
        ChannelFuture future;
        //初始化配置(bootstrap是在构造器中传过来的)
        synchronized (bootstrap) {
            bootstrap.handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(handlers());//从ChannelPipeline中获取所有的处理器
                }
            });
            future = bootstrap.connect(host, port);
        }
        //future对象
        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture f) throws Exception {
                boolean succeed = f.isSuccess();
                //如果重连失败，则调用ChannelInactive方法，再次出发重连事件，一直尝试12次，如果失败则不再重连
                if (!succeed) {
                    System.out.println("重连失败");
                    f.channel().pipeline().fireChannelInactive();
                } else {
                    System.out.println("重连成功");
                }
            }
        });
    }

}  
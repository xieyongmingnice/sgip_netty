package com.xunyu.sgip.handler;


import com.xunyu.sgip.dto.Bind;
import com.xunyu.sgip.dto.BindResp;
import com.xunyu.sgip.dto.SGIPCommend;
import com.xunyu.sgip.dto.Submint;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class SGIPClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        sendBind(ctx);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /**
         * 处理服务端收到的响应
         */
        SGIPCommend sgip = null;
        try {

            //接收消息
            sgip = (SGIPCommend) msg;
            if (sgip.getCommandID() == SGIPCommend.SGIP_BIND_RESP) {
                BindResp br = (BindResp) sgip;
                System.out.println("客户端+++响应状态：" + br.getResult());

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * 释放资源
             */
            ReferenceCountUtil.release(msg);
            //ctx.close();//
        }
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println(cause.getMessage());
        ctx.close();//关闭当前链接
    }

    /**
     * 断连处理逻辑
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //super.channelInactive(ctx);
        /**
         * 只要有一方断开了就走该方法
         * 也可能是自己先挂了，因为netty都是异步操作
         */
        System.out.println("对面（服务端）那小子失联了。。。");
        //ctx.close();//关闭当前链接
    }

    /**
     * 发送bind请求
     */
    private void sendBind(ChannelHandlerContext ctx) {
        //发送绑定命令
        Bind bind = null;
        try {
            bind = new Bind();
            bind.setCommandID(1);
            bind.setLoginName("dth123");
            bind.setLoginPassowrd("123456");
            bind.setLoginType(1);
            ctx.writeAndFlush(bind);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送短信提交命令
     */
    private void sendSubmit(ChannelHandlerContext ctx) {

        Submint sub = new Submint();
        //sub.setCorpId();
    }

}

package com.xunyu.sgip.handler;

import com.xunyu.sgip.dto.Bind;
import com.xunyu.sgip.dto.BindResp;
import com.xunyu.sgip.dto.SGIPCommend;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SGIPServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         *处理客户端的命令
         */
        SGIPCommend sgip = null;
        boolean flag = true;
        try {
            //接收消息
            sgip = (SGIPCommend) msg;
            while (flag) {
                switch (sgip.getCommandID()) {
                    case SGIPCommend.SGIP_BIND: {
                        //转换成具体的对象
                        Bind bind = (Bind) sgip;
                        System.out.println("服务端+++请求链接时生成的序列号1：" + bind.getNodeId());
                        System.out.println("服务端+++请求链接时生成的序列号2：" + bind.getCommandNodeIdDate());
                        System.out.println("服务端+++请求链接时生成的序列号3：" + bind.getCommandNumber());
                        System.out.println("服务端+++登录类型：" + bind.getLoginType());
                        System.out.println("服务端+++用户名：" + bind.getLoginName());
                        System.out.println("服务端+++密码：" + bind.getLoginPassowrd());
                        System.out.println("服务端+++本次的请求方式CommedID=" + bind.getCommandID());
                        //响应本次绑定事件
                        BindResp br = new BindResp();
                        br.setResult(0);
                        br.setCommandID(SGIPCommend.SGIP_BIND_RESP);
                        br.setNodeId(sgip.getNodeId());
                        br.setCommandNodeIdDate(sgip.getCommandNodeIdDate());
                        br.setCommandNumber(sgip.getCommandNumber());
                        br.setSequenceNumber(sgip.getSequenceNumber());
                        ctx.writeAndFlush(br);
                        //.addListener(ChannelFutureListener.CLOSE);//目的是发送完请求断开链接;
                        flag = false;
                        break;
                    }
                    case SGIPCommend.SGIP_SUBMIT: {

                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        //Thread.sleep(5000);
        //ctx.close();//断开当前链接以便测试心跳
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println(cause.getMessage());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //super.channelInactive(ctx);
        /**
         * 只要有一方断开了就走该方法
         */
        System.out.println("对面（客户端）那小子失联了。。。");
        //ctx.close(); //关闭当前链接
        //尝试连接客户端


    }

}

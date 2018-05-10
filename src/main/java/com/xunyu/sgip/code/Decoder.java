package com.xunyu.sgip.code;

import com.xunyu.sgip.dto.Bind;
import com.xunyu.sgip.dto.SGIPCommend;
import com.xunyu.sgip.utils.SGIPUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class Decoder extends ByteToMessageDecoder {

    /**
     * 解码
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Bind bind = new Bind();
        int typeCount = in.readableBytes();//本次请求的字节总数
        SGIPCommend.MessageLength = typeCount;
        in = in.readBytes(in, 4);
        System.out.println(SGIPUtils.ByteArrayToInt2(new byte[in.readableBytes()]));

    }

}

package com.xunyu.sgip.code;

import com.xunyu.sgip.dto.Bind;
import com.xunyu.sgip.dto.SGIPCommend;
import com.xunyu.sgip.utils.SGIPUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.Serializable;

public class Encoder extends MessageToByteEncoder<SGIPCommend> implements Serializable {


    private static final long serialVersionUID = -5239214323840627713L;

    //编码
    @Override
    protected void encode(ChannelHandlerContext ctx, SGIPCommend sgip, ByteBuf buf) throws Exception {


        if (sgip != null) {
            if (sgip.getCommandID() == 1) {
                Bind b = (Bind) sgip;
                buf.writeBytes(SGIPUtils.IntToByteArray2(b.getCommandID()));
                buf.writeBytes(SGIPUtils.IntToByteArray2(b.getNodeId()));
                buf.writeBytes(SGIPUtils.IntToByteArray2(b.getCommandNumber()));
                buf.writeBytes(SGIPUtils.IntToByteArray2(b.getCommandNodeIdDate()));
                buf.writeBytes(SGIPUtils.IntToByteArray2(b.getLoginType()));
                buf.writeBytes(String.valueOf(b.getLoginName()).getBytes("utf-16"));
                buf.writeBytes(String.valueOf(b.getLoginPassowrd()).getBytes("utf-16"));

            }
        }
        /**
         * 便利对象中所有的Integer属性

         Map<String,Object> map = new HashMap<String, Object>();
         BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
         PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
         for (PropertyDescriptor property : propertyDescriptors) {
         String key = property.getName();
         if (key.compareToIgnoreCase("class") == 0) {
         continue;
         }
         Method getter = property.getReadMethod();
         Object value = getter!=null ? getter.invoke(obj) : null;
         //判断属性
         Class<?> gett = property.getPropertyType();
         if("Integer".equalsIgnoreCase(gett.getSimpleName())){
         String inter = String.valueOf(value);

         //转码
         byte[] by = SGIPUtils.IntToByteArray2(Integer.parseInt(inter));
         buf.writeBytes(by);//写到通道中

         }else{
         buf.writeBytes(String.valueOf(value).getBytes("utf-16"));//写到通道中

         }

         }

         buf.writeBytes(buf);
         */
    }


}

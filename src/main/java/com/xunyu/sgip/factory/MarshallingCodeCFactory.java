package com.xunyu.sgip.factory;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public class MarshallingCodeCFactory {

    /**
     * @return
     * @autor dth
     * 解码器
     */
    public static MarshallingDecoder buildMarshallingDecoder() {
        /*
         * 通过 Marshalling 工具类的 getProvidedMarshallerFactory
         * 静态方法获取MarshallerFactory 实例,
         * 参数 serial 表示创建的是 Java 序列化工厂对象.它是由
         * jboss-marshalling-serial 包提供
         */
        final MarshallerFactory marshallerFactory = Marshalling
                .getProvidedMarshallerFactory("serial");
        /*
         * 创建
         */
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);

        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(
                marshallerFactory, configuration);
        /*
         * provider : 提供商 maxSize : 单个对象最大尺寸
         */
        int maxSize = 1024 << 2;
        MarshallingDecoder decoder = new MarshallingDecoder(provider, maxSize);
        return decoder;
    }

    /**
     * @return
     * @autor dth
     * 编码器
     */
    public static MarshallingEncoder buildMarshallingEncoder() {
        final MarshallerFactory marshallerFactory = Marshalling
                .getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        System.out.println("当前请求的字节数" + configuration.getBufferSize());
        MarshallerProvider provider = new DefaultMarshallerProvider(
                marshallerFactory, configuration);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }

}
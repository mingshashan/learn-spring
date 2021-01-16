package com.mingshashan.learn.netty.rpc.common;

import java.io.IOException;

/**
 * Serializer
 *
 * @author xufj
 */
public interface Serializer {

    /**
     * 序列化
     *
     * @param object
     * @return
     * @throws IOException
     */
    byte[] serializer(Object object) throws IOException;

    /**
     * 反序列化
     *
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserializer(Class<T> clazz, byte[] bytes) throws IOException;
}

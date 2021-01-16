package com.mingshashan.learn.netty.rpc.common;

import java.io.IOException;

/**
 * JSONSerializer
 *
 * @author xufj
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte[] serializer(Object object) throws IOException {

        return JSONUtil.toJsonBytes(object);
    }

    @Override
    public <T> T deserializer(Class<T> clazz, byte[] bytes) throws IOException {
        return JSONUtil.toObject(bytes, clazz);
    }
}

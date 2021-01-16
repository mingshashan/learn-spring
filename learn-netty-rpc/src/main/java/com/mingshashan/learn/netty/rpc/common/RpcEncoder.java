package com.mingshashan.learn.netty.rpc.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * RpcEncoder
 *
 * @author xufj
 */
public class RpcEncoder extends MessageToByteEncoder {

    private Class<?> clazz;
    private Serializer serializer;

    public RpcEncoder(Class<?> clazz, Serializer serializer) {
        this.clazz = clazz;
        this.serializer = serializer;
    }

    /**
     * Encode a message into a {@link ByteBuf}. This method will be called for each written message that can be handled
     * by this encoder.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link MessageToByteEncoder} belongs to
     * @param msg the message to encode
     * @param out the {@link ByteBuf} into which the encoded message will be written
     * @throws Exception is thrown if an error occurs
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (null != clazz && null != serializer) {
            byte[] bytes = serializer.serializer(msg);
            out.writeInt(bytes.length);
            out.writeBytes(bytes);
        }
    }
}

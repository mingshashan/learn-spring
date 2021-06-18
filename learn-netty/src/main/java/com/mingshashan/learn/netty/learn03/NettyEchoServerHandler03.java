package com.mingshashan.learn.netty.learn03;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class NettyEchoServerHandler03 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.printf("Receive client: [%s]\n", ((ByteBuf) msg).toString(StandardCharsets.UTF_8));
    }
}

package com.mingshashan.learn.netty.netty01;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * ServerChannelHandler
 *
 * @author jasonxu
 */
public class CustomServerChannel extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("encoder", new StringEncoder());
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("serverCustomHandler", new CustomServerHandler());
    }
}

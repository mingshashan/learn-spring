package com.mingshashan.learn.netty.netty01;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * NettyClient
 *
 * @author jasonxu
 */
public class NettyClient implements Runnable {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 9301;

    public static void main(String[] args) {
        new Thread(new NettyClient()).start();
    }

    @Override
    public void run() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new CustomClientChannel());

        try {
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress(IP, PORT)).sync();
            channelFuture.channel().writeAndFlush("haha");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}

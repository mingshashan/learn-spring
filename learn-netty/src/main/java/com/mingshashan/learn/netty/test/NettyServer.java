package com.mingshashan.learn.netty.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * NettyServer
 *
 * @author jasonxu
 */
public class NettyServer {

    private static final String IP = "127.0.0.1";
    public static final int PORT = 9201;

    private static final int BIZ_GROUP_SIZE = Runtime.getRuntime().availableProcessors();

    private static final int BIZ_THREAD_SIZE = 100;

    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZ_GROUP_SIZE);
    private static final EventLoopGroup workGroup = new NioEventLoopGroup(BIZ_THREAD_SIZE);

    private static void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {

                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline channelPipeline = ch.pipeline();

                        channelPipeline.addLast(
                                new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                        channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                        channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                        channelPipeline.addLast(new TcpServerHandler());
                    }
                });

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(IP, PORT)).sync();
            channelFuture.channel().closeFuture().sync();
            System.out.println("Netty server start at " + PORT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void shutdown() {
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }


    public static void main(String[] args) {
        System.out.println("开始启动Netty Server");
        NettyServer.start();
    }
}

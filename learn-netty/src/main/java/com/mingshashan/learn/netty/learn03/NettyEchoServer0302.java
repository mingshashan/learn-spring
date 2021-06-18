package com.mingshashan.learn.netty.learn03;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.nio.charset.StandardCharsets;

/**
 * 分割符解码器
 */
public class NettyEchoServer0302 {

    public void start(int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();

        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup(2);

        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {

                        ByteBuf delimiter1 = Unpooled.wrappedBuffer("&".getBytes(StandardCharsets.UTF_8));
                        ByteBuf delimiter2 = Unpooled.wrappedBuffer("*".getBytes(StandardCharsets.UTF_8));


                        ch.pipeline()
                                .addLast("delimiterDecoder", new DelimiterBasedFrameDecoder(10, true, true, delimiter1, delimiter2))
                                .addLast("customDecoder", new NettyEchoServerHandler03());
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true);


        try {
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("NettyEchoServer started...");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 18032;
        new NettyEchoServer0302().start(port);
    }
}

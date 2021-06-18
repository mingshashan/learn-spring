package com.mingshashan.learn.netty.learn01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * HttpServer
 *
 * @author xufj
 */
public class HttpServer {

    public static void main(String[] args) {
        new HttpServer().start();
    }

    public void start() {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker);

        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer() {

            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline()
                        .addLast("codec", new HttpServerCodec())
                        .addLast("compressor", new HttpContentCompressor())
                        .addLast("aggregator", new HttpObjectAggregator(65535))
                        .addLast("handler", new MyHttpServerHandler());
            }
        }).childOption(ChannelOption.SO_KEEPALIVE, true);

        try {
            ChannelFuture future = serverBootstrap.localAddress(18080)
                    .bind().sync();

            System.out.println("Netty http server started..., listening on [18080].");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            System.err.println("启动错误！");
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}

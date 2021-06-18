package com.mingshashan.learn.netty.learn02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HttpServer02 {


    public void start(int port) {

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new SampleInBoundHandler("SampleInBoundHandlerA", false))
                                .addLast(new SampleInBoundHandler("SampleInBoundHandlerB", false))
                                .addLast(new SampleInBoundHandler("SampleInBoundHandlerC", true))
                                .addLast(new SampleOutBoundHandler("SampleOutBoundHandlerA"))
                                .addLast(new SampleOutBoundHandler("SampleOutBoundHandlerB"))
                                .addLast(new SampleOutBoundHandler("SampleOutBoundHandlerC"))
                                .addLast(new ExceptionHandler());

                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true);

        try {
            ChannelFuture future = bootstrap.localAddress(port).bind().sync();
            System.out.printf("HttpServer02 started at port = [%d]... \n", port);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        HttpServer02 httpServer02 = new HttpServer02();
        httpServer02.start(18081);
    }

}

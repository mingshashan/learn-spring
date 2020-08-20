package com.mingshashan.learn.netty.netty01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * NettyServer
 *
 * @author jasonxu
 */
public class NettyServer implements Runnable {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 9301;

    private static final int BOSS_THREADS = 2;
    private static final int WORKER_THREADS = 10;


    public static void main(String[] args) {
        new Thread(new NettyServer()).start();
    }


    @Override
    public void run() {

        final EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(BOSS_THREADS);
        final EventLoopGroup workerEventLoopGroup = new NioEventLoopGroup(WORKER_THREADS);

        // 初始化
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossEventLoopGroup, workerEventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new CustomServerChannel());

        // 绑定端口，启动
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(IP, PORT)).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            bossEventLoopGroup.shutdownGracefully();
            workerEventLoopGroup.shutdownGracefully();
        }
    }
}

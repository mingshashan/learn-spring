package com.mingshashan.learn.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * EchoServer
 *
 * @author jasonxu
 */
public class EchoClient {

    private int port;

    public EchoClient(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new EchoClient(9101).start();
    }

    private void start() {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
//                .localAddress(port)
                .remoteAddress(new InetSocketAddress("localhost", port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EchoClientHandler());
                    }
                });

        try {
            // 连接到远程节点，阻塞等待到连接完成
            ChannelFuture channelFuture = bootstrap.connect().sync();

            // 阻塞直到Channel关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                eventLoopGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}

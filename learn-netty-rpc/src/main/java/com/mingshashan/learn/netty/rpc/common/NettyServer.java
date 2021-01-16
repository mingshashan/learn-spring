package com.mingshashan.learn.netty.rpc.common;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * NettyServer
 *
 * @author xufj
 */
public class NettyServer {
    //implements InitializingBean
    private EventLoopGroup bossGroup = null;
    private EventLoopGroup workerGroup = null;

    private static int DEFAULT_PORT = 8888;

    private ServerHandler serverHandler;

    public NettyServer() {
        serverHandler = new ServerHandler();
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }

    public void start() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new RpcEncoder(RpcResponse.class, new JSONSerializer()))
                                .addLast(new RpcDecoder(RpcRequest.class, new JSONSerializer()))
                                .addLast(serverHandler);
                    }
                });

        bind(serverBootstrap, DEFAULT_PORT);
    }

    private void bind(ServerBootstrap serverBootstrap, int port) {

        try {
            serverBootstrap.bind(port).addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("[" + port + "]启动成功");
                } else {
                    System.out.println("[" + port + "]启动失败");
                    bind(serverBootstrap, port + 1);
                }
            }).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destory() {
        try {
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
            System.out.println("关闭Netty");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.mingshashan.learn.netty.rpc.common;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * NettyClient
 *
 * @author xufj
 */
public class NettyClient {

    private static final int MAX_RETRY = 5;
    private String host;
    private int port;

    private EventLoopGroup eventLoopGroup;
    private Channel channel;
    private ClientHandler clientHandler;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws InterruptedException {
        clientHandler = new ClientHandler();
        eventLoopGroup = new NioEventLoopGroup();

        //startup
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new RpcEncoder(RpcRequest.class, new JSONSerializer()))
                                .addLast(new RpcDecoder(RpcResponse.class, new JSONSerializer()))
                                .addLast(clientHandler);
                    }
                });

        connect(bootstrap, host, port, MAX_RETRY);
    }

    private void connect(Bootstrap bootstrap, String host, int port, int retry) throws InterruptedException {

        ChannelFuture channelFuture =
                bootstrap.connect(host, port)
                        .addListener(future -> {
                            if (future.isSuccess()) {
                                System.out.println("连接服务器成功");
                            } else if (retry == 0) {
                                System.out.println("重试5次后无法连接，退出。。。");
                            }
//                            else {
//                                int retryMark = (MAX_RETRY - retry) + 1;
//                                int delay = 1 << retryMark;
//                                bootstrap.config().group()
//                                        .schedule(() -> connect(bootstrap, host, port, MAX_RETRY), delay, TimeUnit.SECONDS);
//                            }

                        }).sync();

        channel = channelFuture.channel();
    }

    public RpcResponse send(final RpcRequest rpcRequest) throws ExecutionException, InterruptedException {
        ChannelFuture channelFuture = channel.writeAndFlush(rpcRequest);

        channelFuture.await();

        return clientHandler.getRpcResponse(rpcRequest.getRequestId());

    }

    public void close() {
        eventLoopGroup.shutdownGracefully();
        channel.closeFuture().syncUninterruptibly();
    }

}

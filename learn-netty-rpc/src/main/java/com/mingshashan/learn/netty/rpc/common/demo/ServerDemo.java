package com.mingshashan.learn.netty.rpc.common.demo;

import com.mingshashan.learn.netty.rpc.common.NettyServer;

/**
 * ServerDemo
 *
 * @author xufj
 */
public class ServerDemo {

    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start();
    }

}

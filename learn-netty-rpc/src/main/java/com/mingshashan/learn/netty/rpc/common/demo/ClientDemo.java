package com.mingshashan.learn.netty.rpc.common.demo;

import com.mingshashan.learn.netty.rpc.common.NettyClient;
import com.mingshashan.learn.netty.rpc.common.ProxyFactory;

/**
 * ClientDemo
 *
 * @author xufj
 */
public class ClientDemo {
    public static void main(String[] args) throws InterruptedException {
        String host = "127.0.0.1";
        int port = 8888;
        NettyClient nettyClient = new NettyClient(host, port);
        nettyClient.connect();
        IHelloService helloService = ProxyFactory.create(IHelloService.class);
        String ret = helloService.hello("haha");
        System.out.println(ret);
    }
}

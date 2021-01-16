package com.mingshashan.learn.netty.rpc.common.demo;

/**
 * HelloServiceImpl
 *
 * @author xufj
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}

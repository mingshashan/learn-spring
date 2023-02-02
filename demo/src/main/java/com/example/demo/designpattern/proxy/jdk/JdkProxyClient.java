package com.example.demo.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkProxyClient {

    public static void main(String[] args) {
        Player xiaoMing = new XiaoMing();

        InvocationHandler invocationHandler = new PlayerInvocationHandler(xiaoMing, new PlayerCustomHandler() {
            @Override
            public void before() {
                System.out.println("代玩开始");
            }

            @Override
            public void after() {
                System.out.println("代玩结束");
            }
        });
        Player other = (Player) Proxy.newProxyInstance(xiaoMing.getClass().getClassLoader(), xiaoMing.getClass().getInterfaces(),
                invocationHandler);

        other.playGame();
    }
}

package com.example.demo.designpattern.proxy.cglib;

import com.example.demo.designpattern.proxy.jdk.PlayerCustomHandler;
import net.sf.cglib.proxy.Enhancer;

public class CglibClient {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoMing.class);
        enhancer.setCallback(new PlayerMethodInterceptor(new PlayerCustomHandler() {
            @Override
            public void before() {
                System.out.println("代玩开始");
            }

            @Override
            public void after() {
                System.out.println("代玩结束");
            }
        }));

        Player player = (Player) enhancer.create();

        player.playGame();
    }
}

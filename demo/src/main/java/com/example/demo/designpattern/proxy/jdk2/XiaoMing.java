package com.example.demo.designpattern.proxy.jdk2;

import com.example.demo.designpattern.proxy.staticproxy.Player;

public class XiaoMing implements Player {
    @Override
    public void playGame() {
        System.out.println("小明的号玩游戏");
    }
}

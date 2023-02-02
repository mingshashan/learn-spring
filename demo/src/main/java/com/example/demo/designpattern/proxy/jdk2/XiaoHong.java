package com.example.demo.designpattern.proxy.jdk2;

import com.example.demo.designpattern.proxy.staticproxy.Player;

public class XiaoHong implements com.example.demo.designpattern.proxy.staticproxy.Player {

    private com.example.demo.designpattern.proxy.staticproxy.Player player;

    public XiaoHong(Player player) {
        this.player = player;
    }
    @Override
    public void playGame() {
        System.out.println("小红代玩---begin");
        player.playGame();
        System.out.println("小红代玩---end");
    }
}

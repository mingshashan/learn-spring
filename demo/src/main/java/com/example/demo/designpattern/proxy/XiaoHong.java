package com.example.demo.designpattern.proxy;

public class XiaoHong implements Player{

    private Player player;

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

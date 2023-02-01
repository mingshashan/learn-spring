package com.example.demo.designpattern.proxy;

public class PlayerTest {

    public static void main(String[] args) {
        Player xiaoMing = new XiaoMing();
        Player xiaoHong = new XiaoHong(xiaoMing);
        xiaoHong.playGame();
    }
}

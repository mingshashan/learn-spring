package com.example.demo.strategy;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/3/28 13:01
 */
public class XiaoMing {
    public static void main(String[] args) {

        Traffic traffic = new Bus();
        System.out.println("今天怎么去上班：");
        traffic.goToWork();
    }
}

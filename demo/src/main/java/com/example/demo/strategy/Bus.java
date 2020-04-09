package com.example.demo.strategy;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/3/28 13:12
 */
public class Bus implements Traffic{
    @Override
    public void goToWork() {
        System.out.println("坐公交车");
    }
}

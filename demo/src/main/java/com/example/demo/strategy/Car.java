package com.example.demo.strategy;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/3/28 13:15
 */
public class Car implements Traffic{

    @Override
    public void goToWork() {
        System.out.println("开车");
    }
}

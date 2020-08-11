package com.mingshashan.learn.spi.traffic;

/**
 * Car
 *
 * @author jasonxu
 */
public class Car implements ITraffic{
    @Override
    public void go() {
        System.out.println("开车");
    }
}

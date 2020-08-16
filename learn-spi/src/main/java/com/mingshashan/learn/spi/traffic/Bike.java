package com.mingshashan.learn.spi.traffic;

/**
 * Bike
 *
 * @author jasonxu
 */
public class Bike implements ITraffic{
    @Override
    public void go() {
        System.out.println("骑自行车");
    }
}

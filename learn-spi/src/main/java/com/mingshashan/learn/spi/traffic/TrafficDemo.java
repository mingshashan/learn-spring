package com.mingshashan.learn.spi.traffic;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * TrafficDemo
 *
 * @author jasonxu
 */
public class TrafficDemo {
    public static void main(String[] args) {
        ServiceLoader.load(ITraffic.class).reload();
        ServiceLoader<ITraffic> serviceLoader = ServiceLoader.load(ITraffic.class);
//        Iterator<ITraffic> trafficIterator =  serviceLoader.iterator();
//        while (trafficIterator.hasNext()) {
//            trafficIterator.next().go();
//        }

        for (ITraffic traffic : serviceLoader) {
            traffic.go();
        }
    }
}

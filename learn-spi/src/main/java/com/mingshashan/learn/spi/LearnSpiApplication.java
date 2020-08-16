package com.mingshashan.learn.spi;

import com.mingshashan.learn.spi.traffic.ITraffic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ServiceLoader;

//@SpringBootApplication
public class LearnSpiApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(LearnSpiApplication.class, args);
//    }

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

package com.mingshashan.learn.webflux.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * FluxAsyncDemo
 *
 * @author jasonxu
 */
public class FluxAsyncDemo {
    public static void main(String[] args) {
//        Flux.range(0, 10)
//                .publishOn(Schedulers.single()).subscribe(Utils::print);
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Flux.range(0, 10)
                .publishOn(Schedulers.parallel()).subscribe(Utils::print);
        try {
            Thread.currentThread().join(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

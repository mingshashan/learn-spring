package com.mingshashan.learn.webflux.reactor;

import reactor.core.publisher.Flux;

/**
 * FluxAPIDemo
 *
 * @author jasonxu
 */
public class FluxAPIDemo {

    public static void main(String[] args) {
        Flux.generate(() -> 0, (value, sink) -> {
            if (value == 3) {
                sink.complete();
            } else {
                sink.next("value = " + value);
            }
            return value + 1;
        }).subscribe(Utils::print);

        long m = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        System.out.println(m);
    }
}

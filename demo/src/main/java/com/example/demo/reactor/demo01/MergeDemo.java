package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * MergeDeom
 *
 * @author jasonxu
 */
public class MergeDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux<Long> flux1 = Flux.interval(Duration.ofSeconds(1), Duration.ofSeconds(1));
        Flux<Long> flux2 = Flux.interval(Duration.ofSeconds(2), Duration.ofSeconds(1));
        Flux<Long> mergedFlux = Flux.merge(flux1, flux2);
        mergedFlux.subscribe(System.out::println);
        Thread.sleep(6000);
    }
}

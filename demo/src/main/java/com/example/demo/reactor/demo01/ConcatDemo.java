package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;

/**
 * ConcatDemo
 *
 * @author jasonxu
 */
public class ConcatDemo {
    public static void main(String[] args) {
        Flux<Integer> source1 = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> source2 = Flux.just(2, 3, 4, 5, 6);
        Flux<Integer> concatFlux = Flux.concat(source1, source2);
        concatFlux.subscribe(System.out::println);
    }
}

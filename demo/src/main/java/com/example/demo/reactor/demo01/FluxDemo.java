package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;

/**
 * FluxDemo
 *
 * @author jasonxu
 */
public class FluxDemo {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("one", "two", "three", "four");
        flux.subscribe(System.out::println);
    }
}

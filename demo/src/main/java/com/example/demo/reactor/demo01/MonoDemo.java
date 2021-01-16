package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * MonoDemo
 *
 * @author jasonxu
 */
public class MonoDemo {
    public static void main(String[] args) {

//        Mono<String> mono = Mono.justOrEmpty("haha");
//        mono.subscribe(System.out::println);

        Mono<String> mono = Mono.just("haha");
        mono.subscribe(System.out::println);

        Flux<String> flux = Flux.just("h1", "h2", "h3");
        flux.subscribe(System.out::println);

    }
}

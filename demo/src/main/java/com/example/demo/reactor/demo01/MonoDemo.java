package com.example.demo.reactor.demo01;

import reactor.core.publisher.Mono;

/**
 * MonoDemo
 *
 * @author jasonxu
 */
public class MonoDemo {
    public static void main(String[] args) {

        Mono<String> mono = Mono.justOrEmpty("haha");
        mono.subscribe(System.out::println);

    }
}

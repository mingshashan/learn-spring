package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * SimpleExpect
 *
 * @author jasonxu
 */
public class SimpleExpect {
    public static void main(String[] args) {
        StepVerifier.create(Flux.just("one", "two", "three"))
                .expectNext("one")
                .expectNext("two")
                .expectNext("three")
                .expectComplete()
                .verify();
    }
}

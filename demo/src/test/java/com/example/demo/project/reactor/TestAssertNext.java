package com.example.demo.project.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;

public class TestAssertNext {
    @Test
    public void test() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        StepVerifier.create(just)
                .assertNext(integer -> {
                    assertEquals(1, integer.intValue());
                }).assertNext(integer -> {
            assertEquals(2, integer.intValue());
        }).assertNext(integer -> {
            assertEquals(3, integer.intValue());
        }).verifyComplete();
    }

}
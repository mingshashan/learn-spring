package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Interval
 *
 * @author jasonxu
 */
public class Interval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1), Duration.ofSeconds(1))
                .subscribe(System.out::println);
        try {
            Thread.sleep(7000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

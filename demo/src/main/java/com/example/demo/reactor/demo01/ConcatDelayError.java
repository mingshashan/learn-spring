package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;

import java.util.function.Consumer;

/**
 * ConcatDelayError
 *
 * @author jasonxu
 */
public class ConcatDelayError {

    public static void main(String[] args) {
        Flux<Integer> sourceWithErrorNumFormat = Flux.just("1", "2", "3", "4", "Five")
                .map(Integer::parseInt);
        Flux<Integer> source = Flux.just("5", "6", "7", "8", "9")
                .map(Integer::parseInt);

        Flux<Integer> concatFlux = Flux.concatDelayError(sourceWithErrorNumFormat, source);
        concatFlux.subscribe((Consumer<? super Integer>) new Mysubscribe("concatDelayError"));
    }


}

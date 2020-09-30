package com.example.demo.reactor.demo01;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * FromPublisher
 *
 * @author jasonxu
 */
public class FromPublisher {

    public static void main(String[] args) {
        Publisher<Integer> fluxPublisher = Flux.just(1, 2, 3);
        Publisher<Integer> monoPublish = Mono.just(0);

        System.out.println("Flux from flux");
        Flux.from(fluxPublisher).subscribe(System.out::println);

        System.out.println("Flux from mono");
        Flux.from(monoPublish).subscribe(System.out::println);
    }
}

package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * SimpleExpectError
 *
 * @author jasonxu
 */
public class SimpleExpectError {
    public static void main(String[] args) {
        Flux<Integer> integerFluxWithException =
                Flux.just(new DivideIntegerSupplier(1, 2),
                        new DivideIntegerSupplier(8, 2),
                        new DivideIntegerSupplier(20, 10),
                        //异常数据,抛出ArithmeticException
                        new DivideIntegerSupplier(1, 0),
                        new DivideIntegerSupplier(2, 2))
                        .map(divideIntegerSupplier -> divideIntegerSupplier.get());

        StepVerifier.create(integerFluxWithException)
                .expectNext(1 / 2)
                .expectNext(8 / 2)
                .expectNext(20 / 10)
                .expectError(ArithmeticException.class)
                .verify();
    }
}

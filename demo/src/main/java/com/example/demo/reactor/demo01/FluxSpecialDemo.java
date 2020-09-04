package com.example.demo.reactor.demo01;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

/**
 * FluxSpecialDemo
 *
 * @author jasonxu
 */
public class FluxSpecialDemo {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber() {

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext-" + o);

            }

            @Override
            public void onError(Throwable t) {
                System.err.println("onError");
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        Flux.empty().subscribe(subscriber);
        System.out.println("-------------------------");
        Flux.error(new RuntimeException("haha")).subscribe(subscriber);
        System.out.println("-------------------------");
        Flux.never().subscribe(subscriber);
        System.out.println("-------------------------");
        Flux.just("a", "b", "c").subscribe(subscriber);
    }
}

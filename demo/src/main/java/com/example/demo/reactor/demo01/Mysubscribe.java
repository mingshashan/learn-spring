package com.example.demo.reactor.demo01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;

import java.util.function.Consumer;

/**
 * Mysubscribe
 *
 * @author jasonxu
 */
public class Mysubscribe implements Consumer, Subscriber, CoreSubscriber {

    private String error;

    public Mysubscribe(String concatDelayError) {
        this.error = concatDelayError;
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param o the input argument
     */
    @Override
    public void accept(Object o) {
        System.out.println(o);
    }

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println(s);
    }

    @Override
    public void onError(Throwable t) {
        try {
            throw t;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Successful terminal state.
     * <p>
     * No further events will be sent even if {@link Subscription#request(long)} is invoked again.
     */
    @Override
    public void onComplete() {
        System.out.println("complete");
    }

    @Override
    public void onNext(Object o) {
        System.out.println(o);
    }
}

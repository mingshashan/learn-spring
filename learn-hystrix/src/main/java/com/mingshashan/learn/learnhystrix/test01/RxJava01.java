package com.mingshashan.learn.learnhystrix.test01;

import rx.Observable;
import rx.Subscriber;

/**
 * RxJava01
 *
 * @author xufj
 */
public class RxJava01 {
    public static void main(String[] args) {
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };

        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World!");
            }
        });

        myObservable.subscribe(mySubscriber);
    }
}

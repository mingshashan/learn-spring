package com.example.demo.reactor.demo01;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;

public class FluxPublishOnThreadSwitch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Flux.range(1, 20)
                .map(i -> {
                    System.out.println("map in Thread " + Thread.currentThread().getName() + " value is " + i);
                    return ++i;
                })
                //使用Schedulers.parallel()线程池执行之后的操作
                .publishOn(Schedulers.parallel())
                .doOnComplete(() -> countDownLatch.countDown())
                .subscribe(i -> {
                    System.out.println("Current Thread is "
                            + Thread.currentThread().getName() + ", value " + i);
                });
        //如果使用了Scheduler，则subscribe是异步的，主线程必须阻塞才行
        System.out.println(Thread.currentThread().getName() + "-Main thread blocking");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "-Flow complete,Main thread run and finished");
    }
}
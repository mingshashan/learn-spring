package com.mingshashan.learn.hello.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Lock04 {
    // 类的成员变量

    public static void main(String[] args) {

        LongAdder data = new LongAdder();

        IntStream.range(0, 2).forEach((i) -> {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntStream.range(0, 100).forEach(y -> {
                    data.increment();
                });
            }).start();
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data.longValue());
    }

}

package com.mingshashan.learn.hello.thread.lock;

import java.util.stream.IntStream;

public class Lock01 {
    // 类的成员变量
    static int data = 0;

    public static void main(String[] args) {

        final Object lock = new Object();
        IntStream.range(0, 2).forEach(System.out::println);

        IntStream.range(0, 2).forEach((i) -> {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntStream.range(0, 100).forEach(y -> {
                    synchronized (lock) {
                        data++;
                    }
                });
            }).start();
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data);
    }

}

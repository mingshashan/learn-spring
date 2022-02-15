package com.mingshashan.learn.hello.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Lock02 {
    // 类的成员变量
    static int data = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        IntStream.range(0, 2).forEach((i) -> {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntStream.range(0, 100).forEach(y -> {
                    try {
                        lock.lock();
                        data++;
                    } finally {
                        lock.unlock();
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

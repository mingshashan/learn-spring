package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * SeamphoreDemo
 *
 * @author jasonxu
 */
public class SemaphoreDemo {

    Semaphore semaphore = new Semaphore(5);

    public void test() {
        try {
            semaphore.acquire();
            String threadName = Thread.currentThread().getName();
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            System.out.println(threadName + "获取到锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                demo.test();
            }).start();
        }
    }
}

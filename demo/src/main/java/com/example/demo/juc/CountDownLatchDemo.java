package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch
 *
 * @author jasonxu
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        new CountDownLatchDemo().test();
    }

    private final CountDownLatch countDownLatch = new CountDownLatch(5);

    private void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("所有线程执行完");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

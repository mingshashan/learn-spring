package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrierDemo
 *
 * @author jasonxu
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        new CyclicBarrierDemo().test();
    }

    private CyclicBarrier barrier = new CyclicBarrier(10, () -> {
        System.out.println("全部执行完");
    });

    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

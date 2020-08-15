package com.example.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MyService
 *
 * @author jasonxu
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void test() {
        try {
            lock.lock();
            // wait
            System.out.println("开始等待");
            condition.await(1, TimeUnit.SECONDS);

            condition.signal();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName = " + Thread.currentThread().getName()
                        + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyService myService = new MyService();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                myService.test();
            }).start();
        }
    }
}

package com.example.demo.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/3/31 18:09
 */
public class Test {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            Thread.currentThread().setName("thread1");
            synchronized (lock1) {
                System.out.println("thread1 get lock1");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("thread1 get lock2");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("thread2");
            synchronized (lock2) {
                System.out.println("thread2 get lock1");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("thread2 get lock1");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

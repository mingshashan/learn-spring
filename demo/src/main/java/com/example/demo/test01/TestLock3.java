package com.example.demo.test01;

import java.util.concurrent.TimeUnit;

/**
 * TestLock1
 *
 * @author xufj
 */
public class TestLock3 {

    public static void main(String[] args) {
        final Demo3 demo3 = new Demo3();
        Thread t1 = new Thread(() -> {
            demo3.test1();
        }, "test1");

        Thread t2 = new Thread(() -> {
            demo3.test2();
        }, "test2");

        Thread t3 = new Thread(() -> {
            demo3.staticTest();
        }, "test3");

        t1.start();
        t3.start();
        t2.start();

    }
}

class Demo3 {

    public synchronized static void staticTest() {
        System.out.println(Thread.currentThread().getName() + " 获得锁");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 释放锁");
    }

    public synchronized void test1() {
        System.out.println(Thread.currentThread().getName() + " 获得锁");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 释放锁");
    }

    public synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + " 获得锁");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 释放锁");
    }
}
package com.example.demo.test01;

import java.util.concurrent.TimeUnit;

/**
 * TestLock1
 *
 * @author xufj
 */
public class TestLock2 {

    public static void main(String[] args) {
//        final Demo2 demo2 = new Demo2();
        Thread t1 = new Thread(() -> {
            Demo2.staticTest();
        }, "test1");

        Thread t2 = new Thread(() -> {
            Demo2.staticTest();
        }, "test2");

        Thread t3 = new Thread(() -> {
            Demo2.staticTest();
        }, "test3");

        t1.start();
        t3.start();
        t2.start();

    }
}

class Demo2 {

    public synchronized static void staticTest() {
        System.out.println(Thread.currentThread().getName() + "获得锁");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "释放锁");
    }

    public synchronized void test1() {
        System.out.println("test1 获得锁");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1 释放锁");
    }

    public synchronized void test2() {
        System.out.println("test2 获得锁");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("test2 释放锁");
    }
}
package com.example.demo.test01;

import java.util.concurrent.TimeUnit;

/**
 * TestLock1
 *
 * @author xufj
 */
public class TestLock1 {

    public static void main(String[] args) {
        final Demo1 demo1 = new Demo1();
        Thread t1 = new Thread(() -> {
            demo1.test1();
        });

        Thread t2 = new Thread(() -> {
            demo1.test2();
        });
        t1.start();
        t2.start();

    }
}

class Demo1 {

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
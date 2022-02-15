package com.mingshashan.learn.hello.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest01 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("thread interrupted");
            }
        }, "test-thread");
        thread.start();
        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }
}

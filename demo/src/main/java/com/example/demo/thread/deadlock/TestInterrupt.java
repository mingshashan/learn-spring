package com.example.demo.thread.deadlock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * TestInterrupt
 *
 * @author xufj
 */
public class TestInterrupt {

    public volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        final Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000L);
                    System.out.println("Hello World!  " + (++i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("线程停止");
                    Thread.currentThread().interrupt();
                    break;
                }
            }

//            while (true) {
//                try {
//                    Thread.sleep(1000L);
//                    System.out.println("Hello World!  " + (++i));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        });



        Thread t2 = new Thread(() -> {
            while (i < 10) {
                System.out.println("haha");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程t");
            t.interrupt();
        });
        t.start();
        t2.start();

    }
}

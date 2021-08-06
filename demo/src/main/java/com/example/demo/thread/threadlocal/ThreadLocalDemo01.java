package com.example.demo.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalDemo01
 *
 * @author xufj
 */
public class ThreadLocalDemo01 {

    private static int i = 0;
    public static void main(String[] args) throws InterruptedException {

        ThreadLocal threadLocal = new ThreadLocal();
        Thread t1 = new Thread(() -> {
            try {
                i = 1000;
                threadLocal.set(i);
                TimeUnit.SECONDS.sleep(10);
                Integer iV = (Integer) threadLocal.get();

                System.out.println(iV);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        Thread t2 = new Thread(() -> {
            try {
                i = 20;
                threadLocal.set(i);
                TimeUnit.SECONDS.sleep(5);
                Integer iV = (Integer) threadLocal.get();

                System.out.println(iV);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);

    }
}

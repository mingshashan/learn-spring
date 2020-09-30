package com.example.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * TestJoin
 *
 * @author jasonxu
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Thread(new T3());
        Thread t2 = new Thread(new T2(t3));
        Thread t1 = new Thread(new T1(t2));


        t1.start();
//        t1.join();
        t2.start();
//        t2.join();
        t3.start();
//        t3.join();
    }

    static class T1 implements Runnable {

        private Thread after;

        public T1(Thread after) {
            this.after = after;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                after.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1");
        }
    }

    static class T2 implements Runnable {

        private Thread after;

        public T2(Thread after) {
            this.after = after;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                after.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");

        }
    }

    static class T3 implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        }
    }


}

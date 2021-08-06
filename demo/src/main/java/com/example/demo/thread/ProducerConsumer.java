package com.example.demo.thread;

/**
 * ProducerConsumer
 *
 * @author xufj
 */
public class ProducerConsumer {

    private static final int N = 100;
    static final Producer p = new Producer();
    static final Consumer c = new Consumer();
    static final Monitor m = new Monitor();


    public static class Producer extends Thread{
        @Override
        public void run() {
            int item;
            while (true) {
                item = producerItem();
                m.insert(item);
            }
        }

        private int producerItem() {
            return 0;
        }
    }

    public static class Consumer {



    }

    public static class Monitor {


        public void insert(int item) {
        }
    }

}

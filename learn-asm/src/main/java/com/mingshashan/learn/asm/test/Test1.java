package com.mingshashan.learn.asm.test;

/**
 * Test1
 *
 * @author xufj
 */
public class Test1 {

    public static void main(String args[]) {

        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };

        t.run();
        System.out.print("ping");

    }

    static void pong() {
        System.out.print("pong");
    }

}

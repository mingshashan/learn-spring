package com.mingshashan.learn.beans;

import javax.swing.*;

/**
 * Test
 *
 * @author jasonxu
 */
public class Test {
//    private final Runnable consumer = this::consume;

    private final Runnable consumer = () -> consume();

    private void consume() {
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test.consumer).start();
    }
}

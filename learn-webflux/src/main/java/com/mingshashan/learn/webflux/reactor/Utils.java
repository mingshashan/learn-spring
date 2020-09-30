package com.mingshashan.learn.webflux.reactor;

/**
 * Utils
 *
 * @author jasonxu
 */
public class Utils {

    public static void print(Object message) {
        System.out.printf("[Thread : %s ]: %s \n", Thread.currentThread().getName(), message);
    }
}

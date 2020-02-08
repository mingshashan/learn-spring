package com.example.demo.test01;

import java.util.HashSet;

/**
 * ShortSet
 *
 * @author jasonxu
 */
public class ShortSet {
    public static void main(String[] args) {

        HashSet<Short> s = new HashSet<>();
        for (Short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 1);
        }
        System.out.println(s.size());
    }
}

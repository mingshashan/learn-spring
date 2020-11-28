package com.example.demo.thread.deadlock;

/**
 * TestHash
 *
 * @author xufj
 */
public class TestHash {

    public static void main(String[] args) {
        int n = 20;
        System.out.println(n >>> 1);
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
//        Map<Object, Object> ht = new HashMap<>();
//
//        try {
//            ht.put(new Object(), null);
//        } catch (NullPointerException e) {
//            System.out.println("1");
//        }
//        try {
//            ht.put(null, new Object());
//        } catch (NullPointerException e) {
//            System.out.println("2");
//        }
//        try {
//            ht.put(null, null);
//        } catch (NullPointerException e) {
//            System.out.println("3");
//        }
//        try {
//            ht.put(new Object(), new Object());
//        } catch (NullPointerException e) {
//            System.out.println("4");
//        }
    }
}

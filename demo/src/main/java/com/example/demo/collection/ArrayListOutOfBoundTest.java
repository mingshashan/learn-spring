package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ArrayListOutOfBoundTest
 *
 * @author xufj
 */
public class ArrayListOutOfBoundTest {

    private static volatile int flag = 0;

    public static void main(String[] args) {

        Runtime.getRuntime().availableProcessors();

//        int cpu = Runtime.getRuntime().availableProcessors();
//        System.out.println(cpu);
//        List<String> arrayList = new ArrayList<>();
//
//        try {
//            for (int i = 0; i < 1000; i++) {
//                new Thread(() -> {
//                    while (flag < 1) {
//                        System.out.println(Thread.currentThread().getName() + "add");
//                        arrayList.add(UUID.randomUUID().toString());
//                    }
//                }, "Thread-" + i).start();
//            }
//        } catch (Exception e) {
//            flag = 1;
//        }
    }
}

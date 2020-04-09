package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/4/1 20:43
 */
public class HeapTest {
    private static List<String> list = new ArrayList<>();

    static int SIZE = 10000;

    static volatile boolean stop = false;

    public static void main(String[] args) {

        new Thread(() -> {
            while (!stop) {
                List<String> temp = new ArrayList<>();
                for (int i = 0; i < SIZE; i++) {
                    list.add(UUID.randomUUID().toString());
                    temp.add(UUID.randomUUID().toString());
                }
                temp = null;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }).start();

        for (; ; ) {
            if (list.size() > Integer.MAX_VALUE >> 8) {
                stop = true;
                break;
            }
        }

    }


}

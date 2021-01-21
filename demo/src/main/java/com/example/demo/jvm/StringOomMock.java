package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

public class StringOomMock {

    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<String>();
            for (int i = 0; ; i++) {
                System.out.println(i);
                list.add(String.valueOf("String" + i++).intern());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
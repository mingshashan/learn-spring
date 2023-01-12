package com.example.demo.se;

public class IntTest1 {
    public static void main(String[] args) {
        System.out.println(a1.a);
    }
}

class a1 {
    static {
        System.out.println("init class");
    }

    public final static int a = 1;
}
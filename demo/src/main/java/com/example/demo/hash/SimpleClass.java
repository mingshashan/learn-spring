package com.example.demo.hash;

public class SimpleClass {

    //静态代码块
    static {
        System.out.println("执行了静态代码块");
    }

    //静态变量
    private static String staticFiled = staticMethod();

    //赋值静态变量的静态方法
    public static String staticMethod() {
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }

    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz1 = Thread.currentThread().getContextClassLoader().loadClass("com.example.demo.hash.SimpleClass");

        System.out.println("#########分割符##########");
        Class clazz2 = Class.forName("com.example.demo.hash.SimpleClass");
    }
}
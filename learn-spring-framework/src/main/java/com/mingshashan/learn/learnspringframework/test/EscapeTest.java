package com.mingshashan.learn.learnspringframework.test;

public class EscapeTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            createObject();
        }
        System.out.println("cost = " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void createObject() {
        synchronized (new Object()) {

        }
    }

    public static Object globalVariableObject;

    public Object instanceObject;

    public void globalVariableEscape() {
        globalVariableObject = new Object(); //静态变量,外部线程可见,发生逃逸
    }

    public void instanceObjectEscape() {
        instanceObject = new Object(); //赋值给堆中实例字段,外部线程可见,发生逃逸
    }

    public Object returnObjectEscape() {
        return new Object();  //返回实例,外部线程可见，发生逃逸
    }

    public void noEscape() {
        synchronized (new Object()) {
            //仅创建线程可见,对象无逃逸
        }
        Object noEscape = new Object();  //仅创建线程可见,对象无逃逸
    }

}
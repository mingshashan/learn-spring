package com.mingshashan.learn.learnspringboot.aa;

class Outer {

    static class Inner {
    }

    public static void foo() {
        new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
        new Inner();
    }
}
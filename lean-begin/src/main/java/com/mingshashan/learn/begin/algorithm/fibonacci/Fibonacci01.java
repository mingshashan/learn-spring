package com.mingshashan.learn.begin.algorithm.fibonacci;

public class Fibonacci01 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Fibonacci01 fibonacci01 = new Fibonacci01();
//        System.out.printf("fib(1) = %d\n", fibonacci01.fib(1));
//        System.out.printf("fib(2) = %d\n", fibonacci01.fib(2));
//        System.out.printf("fib(3) = %d\n", fibonacci01.fib(3));
//        System.out.printf("fib(4) = %d\n", fibonacci01.fib(4));
//        System.out.printf("fib(5) = %d\n", fibonacci01.fib(5));
//        System.out.printf("fib(6) = %d\n", fibonacci01.fib(6));
//        System.out.printf("fib(7) = %d\n", fibonacci01.fib(7));
//        System.out.printf("fib(8) = %d\n", fibonacci01.fib(8));
//        System.out.printf("fib(9) = %d\n", fibonacci01.fib(9));
//        System.out.printf("fib(10) = %d\n", fibonacci01.fib(10));
//        System.out.printf("fib(11) = %d\n", fibonacci01.fib(11));
//        System.out.printf("fib(18) = %d\n", fibonacci01.fib(18));
//        System.out.printf("fib(19) = %d\n", fibonacci01.fib(19));
//        System.out.printf("fib(20) = %d\n", fibonacci01.fib(20));
        System.out.printf("fib(50) = %d\n", fibonacci01.fib(50));

        System.out.printf("Fibonacci01 总耗时：%d\n", (System.currentTimeMillis() - start));
    }

    long fib(long N) {
        if (1 == N || 2 == N) {
            return 1;
        }

        return fib(N - 1) + fib(N - 2);
    }
}

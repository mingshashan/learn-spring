package com.mingshashan.learn.begin.algorithm.fibonacci;

public class Fibonacci04 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Fibonacci04 fibonacci04 = new Fibonacci04();
//        System.out.printf("fib(1) = %d\n", fibonacci03.fib(1));
//        System.out.printf("fib(2) = %d\n", fibonacci03.fib(2));
//        System.out.printf("fib(3) = %d\n", fibonacci03.fib(3));
//        System.out.printf("fib(4) = %d\n", fibonacci03.fib(4));
//        System.out.printf("fib(5) = %d\n", fibonacci03.fib(5));
//        System.out.printf("fib(6) = %d\n", fibonacci03.fib(6));
//        System.out.printf("fib(7) = %d\n", fibonacci03.fib(7));
//        System.out.printf("fib(8) = %d\n", fibonacci03.fib(8));
//        System.out.printf("fib(9) = %d\n", fibonacci03.fib(9));
//        System.out.printf("fib(10) = %d\n", fibonacci03.fib(10));
//        System.out.printf("fib(11) = %d\n", fibonacci03.fib(11));
//        System.out.printf("fib(18) = %d\n", fibonacci03.fib(18));
//        System.out.printf("fib(19) = %d\n", fibonacci03.fib(19));
//        System.out.printf("fib(20) = %d\n", fibonacci03.fib(20));
        System.out.printf("fib(100) = %d\n", fibonacci04.fib(100));

        System.out.printf("Fibonacci04 总耗时：%d\n", (System.currentTimeMillis() - start));

    }

    long fib(int N) {

        if (1 == N || 2 == N) {
            return 1;
        }

        long pre = 1;
        long curr = 1;

        long sum = 0;
        for (int i = 3; i <= N; i++) {
            sum = pre + curr;
            pre = curr;
            curr = sum;
        }

        return curr;
    }
}

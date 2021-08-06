package com.mingshashan.learn.begin.algorithm.fibonacci;

public class Fibonacci02 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Fibonacci02 fibonacci02 = new Fibonacci02();
//        System.out.printf("fib(1) = %d\n", fibonacci02.fib(1));
//        System.out.printf("fib(2) = %d\n", fibonacci02.fib(2));
//        System.out.printf("fib(3) = %d\n", fibonacci02.fib(3));
//        System.out.printf("fib(4) = %d\n", fibonacci02.fib(4));
//        System.out.printf("fib(5) = %d\n", fibonacci02.fib(5));
//        System.out.printf("fib(6) = %d\n", fibonacci02.fib(6));
//        System.out.printf("fib(7) = %d\n", fibonacci02.fib(7));
//        System.out.printf("fib(8) = %d\n", fibonacci02.fib(8));
//        System.out.printf("fib(9) = %d\n", fibonacci02.fib(9));
//        System.out.printf("fib(10) = %d\n", fibonacci02.fib(10));
//        System.out.printf("fib(11) = %d\n", fibonacci02.fib(11));
//        System.out.printf("fib(18) = %d\n", fibonacci02.fib(18));
//        System.out.printf("fib(19) = %d\n", fibonacci02.fib(19));
//        System.out.printf("fib(20) = %d\n", fibonacci02.fib(20));
        System.out.printf("fib(100) = %d\n", fibonacci02.fib(100));

        System.out.printf("Fibonacci02 总耗时：%d\n", (System.currentTimeMillis() - start));

    }

    long fib(int N) {
        if (N < 1) {
            return 0;
        }
        long[] memo = new long[N + 1];

        return helper(memo, N);
    }

    private long helper(long[] memo, int n) {

        if (1 == n || 2 == n) {
            return 1;
        }
        if (0 != memo[n]) {
            return memo[n];
        }

        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
}

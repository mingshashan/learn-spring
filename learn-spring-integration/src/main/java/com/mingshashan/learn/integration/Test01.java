package com.mingshashan.learn.integration;

/**
 * Test01
 *
 * @author jasonxu
 */
public class Test01 {
    public static void main(String[] args) {
//        int[] a = {
//                9, 6, 8, 3, -1
//        };
//        int i;
//        int j;
//        int t;
//        int p;
//        sort(a);
//        for (i = 0; i <= 4; i++) {
////            printf("=", a[i]);
//            System.out.printf("=" + a[i]);
//        }
    }

    public static void sort(int a[]) {
        int i, j, t, p;
        for (j = 0; j < 4; j++) {
            p = j;
            for (i = j; i <= 4; i++) {
                if (a[i] < a[p]) {
                    p = i;
                }
            }
            t = a[p];
            a[p] = a[j];
            a[j] = t;
        }
    }
}

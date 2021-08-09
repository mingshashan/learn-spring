package com.example.demo.a01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cakes {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 1};
        Cakes cakes = new Cakes();
        List<Integer> result = cakes.pancakesSort(arr);
        System.out.println(result);

        System.out.println(Arrays.toString(arr));
    }

    LinkedList<Integer> res = new LinkedList<>();

    List<Integer> pancakesSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }

    void sort(int[] cakes, int n) {
        // base case
        if (1 == n) {
            return;
        }

        // find max cake index
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }

        // 先把最大的翻到上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // 再翻一次，把最大的翻到最下面
        reverse(cakes, 0, n - 1);

        res.add(n);
        sort(cakes, n - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}

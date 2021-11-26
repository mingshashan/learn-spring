package com.example.demo.a01;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        testSum();
        System.out.println("-----" +
                "-----------------");
        testReverse();
    }

    private static void testReverse() {
        int[] numbers = new int[]{2, 7, 11, 15};

        reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    /**
     * aaa
     */
    private static void testSum() {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 13;

        int[] result = towSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    static int[] towSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

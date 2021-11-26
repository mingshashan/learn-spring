package com.example.demo.lc.dfs;

import java.util.LinkedList;
import java.util.List;

public class FullPermutation {

    public static void main(String[] args) {

        FullPermutation permutation = new FullPermutation();
        int[] nums = new int[]{1,2,3};

        System.out.println(permutation.permutation(nums));
    }

    List<List<Integer>> res = new LinkedList<>();


    List<List<Integer>> permutation(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}

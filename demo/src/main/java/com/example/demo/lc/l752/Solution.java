package com.example.demo.lc.l752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
class Solution {

    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test01() {
        String[] deadends = new String[]{"8888"};
        String target = "0009";
        System.out.println(new Solution().openLock(deadends, target));
    }

    private static void test02() {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"
        };
        String target = "0202";
        System.out.println(new Solution().openLock(deadends, target));
    }


    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>();
        if (null != deadends) {
            for (String str : deadends) {
                deadSet.add(str);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add("0000");
        q.offer("0000");
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (deadSet.contains(cur)) {
                    continue;
                }

                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String plusOne(String s, int j) {
        char[] ca = s.toCharArray();
        if (ca[j] == '9') {
            ca[j] = '0';
        } else {
            ca[j] += 1;
        }

        return new String(ca);
    }

    String minusOne(String s, int j) {
        char[] ca = s.toCharArray();
        if (ca[j] == '0') {
            ca[j] = '9';
        } else {
            ca[j] -= 1;
        }
        return new String(ca);
    }
}
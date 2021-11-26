package com.example.demo.lc.coin;

/**
 * 凑零钱问题
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，
 * 每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
 */
public class CoinProblem {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int result = new CoinProblem().coinChange(coins, amount);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是dp(amount)
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        // base case
        if (0 == amount) {
            return 0;
        }
        if (0 > amount) {
            return -1;
        }

        int res = Integer.MAX_VALUE;

        // 子问题
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            // 子问题无解
            if (0 > subProblem) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

package com.rishi.leetcode.dp;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/16
 **/
public class Solution518 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new Solution518().change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = dp[i] + dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }

}

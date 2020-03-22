package com.rishi.leetcode.dp;

/**
 * @author liuhx
 * @desc 零钱兑换
 * @date 2019/12/15
 **/
public class Solution322 {


    public static void main(String[] args) {
        int[] coins = {2, 5, 10, 1};
        int amount = 27;
        System.out.println(new Solution322().coinChange2(coins, amount));
    }


    /**
     * 使用动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        //确定dp方程
        // dp[i] = min(dp[i - coins[j]) + 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    private int minCount = 0;

    /**
     * 暴力法实现
     * 进行深度优先搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        for (int i = 0; i < coins.length; i++) {
            dfs(i, coins, amount - coins[i], 1);
        }

        return minCount == 0 ? -1 : minCount;
    }

    private void dfs(int i, int[] coins, int amount, int level) {
        //判定逻辑
        if (amount <= 0) {
            if (amount == 0) {
                minCount = (minCount == 0) ? level : Math.min(minCount, level);
            }
            return;
        }

        //处理当前逻辑
        amount -= coins[i];

        //下探操作
        for (int j = 0; j < coins.length; j++) {
            dfs(j, coins, amount, level + 1);
        }
    }
}

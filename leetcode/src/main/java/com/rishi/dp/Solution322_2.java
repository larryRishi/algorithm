package com.rishi.dp;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/13
 **/
public class Solution322_2 {


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println("使用深度优先搜索实现：");
        System.out.println(new Solution322_2().coinChange(coins, 11));
        System.out.println("-----");
        System.out.println("使用动态规划实现：");
        System.out.println(new Solution322_2().coinChange2(coins, 11));
    }


    
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if ((i - coins[j]) >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



    private int minCount;

    /**
     * 使用回溯算法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        dfs(coins, amount, 0);
        return minCount == 0 ? -1 : minCount;
    }

    private void dfs(int[] coins, int amount, int level) {
        if (amount <= 0) {
            if (amount == 0) {
                minCount = minCount == 0 ? level : Math.min(minCount, level);
            }
            return;
        }
        for (int coin : coins) {
            dfs(coins, amount - coin, level + 1);
        }
    }
}

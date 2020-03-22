package com.rishi.leetcode.dp;

import static java.lang.Math.max;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/07
 **/
public class Solution123 {


    public static void main(String[] args) {
        int a = 'a' - 'A';
        System.out.println((int)'z');
    }

    /**
     * 使用动态规划
     * 确定dp方程：i标识天数，j标识是否持有股票，0-未持有，1-持有
     * k标识交易次数
     * dp(i, 0, k) = max(dp(i - 1, 0, k), dp(i - 1, 1, k -1) + prices[i])
     * dp(i, 1, k) = max(dp(i - 1, 1, k), dp(i - 1, 0, k) - prices[i])
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][2][3];
        //初始化dp
        //dp[0][0][0] = 0;
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = Integer.MIN_VALUE >> 1;
        dp[0][1][1] = Integer.MIN_VALUE >> 1;
        dp[0][0][2] = Integer.MIN_VALUE >> 1;
        dp[0][1][2] = Integer.MIN_VALUE >> 1;
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k - 1] + prices[i]);
                System.out.print("dp["+ i +"][0][" + k + "]=" + dp[i][0][k]);
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k] - prices[i]);
                System.out.println(",dp["+ i +"][1]["+k+"]=" + dp[i][1][k]);
            }
        }

        return dp[prices.length - 1][0][2];


    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE >> 1;
        dp[0][1][1] = -prices[0];
        dp[0][1][0] = Integer.MIN_VALUE >> 1;
        dp[0][2][0] = Integer.MIN_VALUE >> 1;
        dp[0][2][1] = Integer.MIN_VALUE >> 1;

        for (int i = 1; i < len; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        //return max(dp[len - 1][0][0], max(dp[len - 1][2][0], dp[len - 1][1][0]));
        return dp[len - 1][2][0];
    }
}

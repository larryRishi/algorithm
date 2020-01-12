package com.rishi.dp;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/12
 **/
public class Solution152 {

    public int maxProduct(int[] nums) {
        // 设dp(i, j) 标识nums序列从i->j的乘积
        // 那么i == j时dp(i, j) = nums[i]
        // 不考虑i > j的情况，否则dp(i, j) = dp(i, j - 1) * nums[j];
        // 时间复杂度N^2,空间复杂度N^2
        int m = nums.length;
        if (m == 0) {
            return 0;
        }
        int[][] dp = new int[m][m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

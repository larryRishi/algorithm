package com.rishi.dp;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/minimum-path-sum/
 * @date 2019/11/17
 **/
public class Solution64 {


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int top = dp[0][0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j] + top;
                min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }


}

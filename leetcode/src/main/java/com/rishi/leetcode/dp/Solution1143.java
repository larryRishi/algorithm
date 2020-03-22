package com.rishi.leetcode.dp;

/**
 * @author liuhx
 * @desc 最长公共子序列
 * @date 2020/01/12
 **/
public class Solution1143 {

    public static void main(String[] args) {
        String text1 = "bl";
        String text2 = "ybl";
        System.out.println(new Solution1143().longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // 类似不同路径问题
        //只考虑已知字符进行推导： a 与 a.. 最长公共子序列为1
        // ac与a..c最长公共子序列为2
        // 设dp(i, j) 标识text1在[0, i]区间和text2在[0, j]区间内的最长公共子序列
        // 所以dp方程为：if text1[i] == text[j]: -> dp(i - 1, j - 1) + 1 else: max(dp(i - 1, j), dp(i, j - 1))
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int m = s.length;
        int n = t.length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


}

package com.rishi.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuhx
 * @desc 三角形最小路径和
 * @date 2020/01/11
 **/
public class Solution120 {

    /**
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     *
     * @param args
     */

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        
        System.out.println("使用dp二维数组，自顶向下：");
        System.out.println(new Solution120().minimumTotal(triangle));
        System.out.println("-------");
        System.out.println("使用二维数组，自底向上：");
        System.out.println(new Solution120().minimumTotal3(triangle));
        System.out.println("-------");
        System.out.println("使用一维数组，自底向上：");
        System.out.println(new Solution120().minimumTotal4(triangle));
    }

    /**
     * 使用dp二维数组，自顶向下
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 推导出dp方程为：dp(i, j) = min(dp(i - 1, j), dp(i - 1, j - 1)) + triangle[i][j]
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int curMin = triangle.get(i).get(j);
                if (j == 0) {
                    curMin += dp[i - 1][0];
                } else if (j == i) {
                    curMin += dp[i - 1][j - 1];
                } else {
                    curMin += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                dp[i][j] = curMin;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(dp[m - 1][i], min);
        }
        return min;
    }

    /**
     * 自底向上
     *
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        // dp(i, j) = min(dp(i + 1, j), dp(i + 1, j + 1)) + triangle[i][j]
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    /**
     * 自底向上,使用一维数组
     *
     * @param triangle
     * @return
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }
        // dp(i, j) = min(dp(i + 1, j), dp(i + 1, j + 1)) + triangle[i][j]
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 复用题设集合，自顶向下
     * *** 无法复用集合，因为Java在遍历集合过程中不能对集合进行写操作
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        // 推导出dp方程为：dp(i, j) = min(dp(i - 1, j), dp(i - 1, j - 1)) + triangle[i][j]
        int m = triangle.size();
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int curMin = triangle.get(i).get(j);
                List<Integer> inner = triangle.get(i - 1);
                if (j == 0) {
                    curMin += inner.get(0);
                } else if (j == i) {
                    curMin += inner.get(j - 1);
                } else {
                    curMin += Math.min(inner.get(j), inner.get(j - 1));
                }
                inner.add(j, curMin);
                triangle.add(i, inner);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(triangle.get(m - 1).get(i), min);
        }
        return min;
    }


}

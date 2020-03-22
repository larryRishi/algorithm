package com.rishi.leetcode.backtrack;

/**
 * @author liuhx
 * @desc 不同路径
 * @date 2019/11/14
 **/
public class Solution62 {

    public static void main(String[] args) {
        int paths = new Solution62().uniquePaths2(7, 3);
        System.out.println(paths);
    }

    /**
     使用分治+备忘录来实现
     */
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        return div(m, n, mem);
    }

    private int div(int m, int n, int[][] mem) {
        if (m == 1 || n == 1) {
            return 1;
        }

        mem[m][n] = mem[m][n] != 0 ? mem[m][n] : div(m - 1, n, mem) + div(m, n - 1, mem);
        return mem[m][n];
    }


    /**
     * 使用动态规划来实现
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        if (m == 1 && n == 1) {
            return 1;
        }
        for (int i = 1; i < m + 1; i++) {
            mem[i][n] = 1;
        }
        for (int j = 1; j < n + 1; j++) {
            mem[m][j] = 1;
        }

        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                mem[i][j] = mem[i + 1][j] + mem[i][j + 1];
            }
        }
        return mem[1][1];
    }

}

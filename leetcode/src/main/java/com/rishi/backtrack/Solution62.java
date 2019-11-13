package com.rishi.backtrack;

/**
 * @author liuhx
 * @desc 不同路径
 * @date 2019/11/14
 **/
public class Solution62 {

    public static void main(String[] args) {
        int paths = new Solution62().uniquePaths(7, 3);
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

}

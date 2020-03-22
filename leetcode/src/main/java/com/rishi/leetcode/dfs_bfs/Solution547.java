package com.rishi.leetcode.dfs_bfs;

/**
 * @author liuhx
 * @desc
 * @date 2019/11/23
 **/
public class Solution547 {

    private int[] di = {-1, 1, 0, 0};

    private int[] dj = {0, 0, -1, 1};

    public int findCircleNum(int[][] M) {
        //可转化为no.200岛屿数量问题
        int nums = 0;
        int N = M.length;
        if (N == 0) {
            return nums;
        }
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, visited, M);
                nums++;
            }
        }
        return nums;
    }

    private void dfs(int i, boolean[] visited, int[][] m) {
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, visited, m);
            }
        }
    }


    public static void main(String[] args) {
        int[][] M = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(new Solution547().findCircleNum(M));
    }


}

package com.rishi.leetcode.dfs_bfs;

/**
 * @author liuhx
 * @desc 岛屿的生成
 * @date 2019/10/29
 **/
public class Solution200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int landsNums = 0;
        int rLength = grid.length;
        int cLength = grid[0].length;
        for (int r = 0; r < rLength; r++) {
            for (int c = 0; c < cLength; c++) {
                if (grid[r][c] == '1') {
                    landsNums++;
                    dfs(grid, r, c, rLength, cLength);
                }
            }
        }
        return landsNums;
    }

    private void dfs(char[][] grid, int r, int c, int rLength, int cLength) {
        //return condition
        if (r < 0
                || c < 0
                || r >= rLength
                || c >= cLength
                || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c, rLength, cLength);
        dfs(grid, r - 1, c, rLength, cLength);
        dfs(grid, r, c + 1, rLength, cLength);
        dfs(grid, r, c - 1, rLength, cLength);
    }

}

package com.rishi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhx
 * @desc n皇后问题
 * @date 2019/11/24
 **/
public class Solution51 {

    private boolean[] colQ;
    //主对角线：i - j == (i + 1) - (j + 1)
    private boolean[] master;
    //次对角线 i + j = (i + 1) + (j - 1)
    private boolean[] slave;

    private int n;


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        colQ = new boolean[n];
        //主对角线：i - j == (i + 1) - (j + 1)
        master = new boolean[2 * n];
        //次对角线 i + j = (i + 1) + (j - 1)
        slave = new boolean[2 * n - 1];

        List<List<String>> ret = new ArrayList<>();
        char[][] broad = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                broad[i][j] = '.';
            }
        }
        backtrack(broad, 0, ret);
        return ret;
    }

    private void backtrack(char[][] broad, int row,
                           List<List<String>> ret) {
        if (row == n) {
            fillList(broad, ret);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (validate(row, col)) {
                placeQueue(row, col, broad);
                backtrack(broad, row + 1, ret);
                removeQueue(row, col, broad);
            }

        }


    }

    private boolean validate(int row, int col) {
        System.out.println("row:" + row + ",col:" + col);
        return !colQ[col]
                && !master[row - col + n]
                && !slave[row + col];
    }

    private void placeQueue(int row, int col, char[][] broad) {
        colQ[col] = true;
        master[row - col + n] = true;
        slave[row + col] = true;
        broad[row][col] = 'Q';
    }

    private void removeQueue(int row, int col, char[][] broad) {
        colQ[col] = false;
        master[row - col + n] = false;
        slave[row + col] = false;
        broad[row][col] = '.';
    }

    private void fillList(char[][] broad, List<List<String>> ans) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(broad[i][j]);
            }
            list.add(row.toString());
        }
        ans.add(list);
    }


    public static void main(String[] args) {
        new Solution51().solveNQueens(10);
    }
}

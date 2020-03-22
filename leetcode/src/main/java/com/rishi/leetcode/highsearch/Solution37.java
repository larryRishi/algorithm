package com.rishi.leetcode.highsearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuhx
 * @desc 解数独
 * @date 2019/11/24
 **/
public class Solution37 {

    public static void main(String[] args) {
        char[][] board = {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
        };
        new Solution37().solveSudoku(board);
        System.out.println();
    }


    private Set<String>[] rows = new HashSet[9];

    private Set<String>[] cols = new HashSet[9];

    private Set<String>[] boxes = new HashSet[9];

    public void solveSudoku(char[][] board) {
        // 横向不能重复，竖向不能重复，每三边不能重复

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String num = String.valueOf(board[i][j]);
                    rows[i].add(num);
                    cols[j].add(num);
                    boxes[(j / 3) + (i / 3) * 3].add(num);
                }
            }
        }
        
        backtrack(0, 0, board);
    }


    private void backtrack(int row, int col, char[][] board) {
        if (row == 9 || col == 9) {
            return;
        }
        if (board[row][col] != '.') {
            return;
        }
        if (!placeNum(row, col, board)) {
            return;
        }
        backtrack(row + 1, col, board);
        backtrack(row, col + 1, board);
        removeNum(row, col, board);

    }


    private boolean placeNum(int i, int j, char[][] board) {
        for (int index = 1; index < 10; index++) {
            String num = index + "";
            if (validate(num, i, j)) {
                board[i][j] = num.charAt(0);
                rows[i].add(num);
                cols[j].add(num);
                boxes[(j / 3) + (i / 3) * 3].add(num);
                return true;
            }
        }
        return false;
    }


    private void removeNum(int i, int j, char[][] board) {
        String num = String.valueOf(board[i][j]);
        rows[i].remove(num);
        cols[j].remove(num);
        boxes[(j / 3) + (i / 3) * 3].remove(num);
        board[i][j] = '.';
    }

    private boolean validate(String num, int i, int j) {
        return !rows[i].contains(num)
                && !cols[j].contains(num)
                && !boxes[(j / 3) + (i / 3) * 3].contains(num);
    }


}

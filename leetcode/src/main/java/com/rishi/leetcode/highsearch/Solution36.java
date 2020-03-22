package com.rishi.leetcode.highsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuhx
 * @desc 有效的数独
 * @date 2019/11/24
 **/
public class Solution36 {

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!row[i].contains(c)) {
                    row[i].add(c);
                } else {
                    return false;
                }

                if (!col[j].contains(c)) {
                    col[j].add(c);
                } else {
                    return false;
                }

                int boxIndex = (j/3) + (i/3)*3;
                if (!boxes[boxIndex].contains(c)) {
                    boxes[boxIndex].add(c);
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}

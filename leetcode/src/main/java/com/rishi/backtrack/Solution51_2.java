package com.rishi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/08
 **/
public class Solution51_2 {

    public static void main(String[] args) {
        List<List<String>> lists = new Solution51_2().solveNQueens(4);
        lists.forEach(list -> {
            list.forEach(val -> System.out.println(val + ","));
            System.out.println("----");
        });

    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }

        boolean[] yVisited = new boolean[n];
        // 撇
        boolean[] aVisited = new boolean[2*n - 1];
        // 捺
        boolean[] bVisited = new boolean[2*n];

        backtrack(0, n, new ArrayList<>(), ans, yVisited, aVisited, bVisited);
        return ans;
    }

    private void backtrack(int n, int max, List<String> list, List<List<String>> ans,
                           boolean[] yVisited, boolean[] aVisited, boolean[] bVisited) {
        if (n == max) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < max; i++) {
            if (yVisited[i] || aVisited[n + i] || bVisited[i - n + max]) {
                continue;
            }
            placeQ(n, i, list, max, yVisited, aVisited, bVisited);
            backtrack(n + 1, max, list, ans, yVisited, aVisited, bVisited);
            removeQ(n, i, list, max, yVisited, aVisited, bVisited);
        }
    }

    private void placeQ(int x, int y, List<String> list, int max, boolean[] yVisited, boolean[] aVisited, boolean[] bVisited) {
        char[] origin = getOrigin(max);
        origin[y] = 'Q';
        list.add(String.valueOf(origin));
        yVisited[y] = true;
        aVisited[x + y] = true;
        bVisited[y - x + max] = true;
    }

    private void removeQ(int x, int y, List<String> list, int max,  boolean[] yVisited, boolean[] aVisited, boolean[] bVisited) {
        list.remove(list.size() - 1);
        yVisited[y] = false;
        aVisited[x + y] = false;
        bVisited[y - x + max] = false;
    }

    private char[] getOrigin(int max) {
        char[] chars = new char[max];
        for (int i = 0; i < max; i++) {
            chars[i] = '.';
        }
        return chars;
    }

}

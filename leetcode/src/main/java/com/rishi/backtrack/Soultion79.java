package com.rishi.backtrack;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/11/19
 **/
public class Soultion79 {

    public static void main(String[] args) {
        /*char[][] board = {{'F', 'Y', 'C', 'E', 'N', 'R', 'D'},
                {'K', 'L', 'N', 'F', 'I', 'N', 'U'},
                {'A', 'A', 'A', 'R', 'A', 'H', 'R'},
                {'N', 'D', 'K', 'L', 'P', 'N', 'E'},
                {'A', 'L', 'A', 'N', 'S', 'A', 'P'},
                {'O', 'O', 'G', 'O', 'T', 'P', 'N'}};
        String word = "FRANCE";*/
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String word = "cdba";
        System.out.println(new Soultion79().exist(board, word));
    }


    private int[] rows = {1, 0, -1, 0};
    private int[] cols = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (dfs(i, j, 0, word, m, n, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int index, String word, int m, int n, char[][] board, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            System.out.println("  false");
            return false;
        }
        if (index + 1 == word.length()) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (dfs(x + rows[i], y + cols[i], index + 1, word, m, n, board, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }


}

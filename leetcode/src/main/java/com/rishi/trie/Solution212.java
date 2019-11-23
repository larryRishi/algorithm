package com.rishi.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuhx
 * @desc
 * @date 2019/11/23
 **/
public class Solution212 {

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}, {'a', 'a'}};
        String[] words = {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        System.out.println(new Solution212().findWords(board, words));
    }

    private int[] dx = {-1, 1, 0, 0};

    private int[] dy = {0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        Trie tire = new Trie();
        for (String word : words) {
            tire.insert(word);
        }
        int m = board.length;
        if (m == 0) {
            return new ArrayList<>(ans);
        }
        int n = board[0].length;
        TrieNode root = tire.root;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                dfs(x, y, m, n, board, "", root, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(int x, int y, int m, int n, char[][] board, String word, TrieNode root, Set<String> ans) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (board[x][y] == '#') {
            return;
        }
        int index = board[x][y] - 'a';
        if (root.children[index] == null) {
            return;
        }
        root = root.children[index];
        word += board[x][y];
        if (root.isEnd) {
            ans.add(word);
        }
        char temp = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], m, n, board, word, root, ans);
        }
        board[x][y] = temp;
    }

}

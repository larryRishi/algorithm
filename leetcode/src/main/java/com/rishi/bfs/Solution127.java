package com.rishi.bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * @author liuhx
 * @desc 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 * @date 2019/10/29
 **/
public class Solution127 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int N = beginWord.length();
        //记录访问过的结点，防止形成环
        List<String> visited = new ArrayList<>();

        Map<String, List<String>> all = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String match = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> orDefault = all.getOrDefault(match, new ArrayList<>());
                orDefault.add(word);
                all.put(match, orDefault);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            Integer level = pair.getValue();
            for (int i = 0; i < N; i++) {
                String match = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> list = all.get(match);
                if (list == null) {
                    continue;
                }
                for (String newWord : list) {
                    if (visited.contains(newWord)) {
                        continue;
                    }
                    if (newWord.equals(endWord)) {
                        System.out.println(newWord + ",");
                        return level + 1;
                    } else {
                        queue.offer(new Pair<>(newWord, level + 1));
                        System.out.print(newWord + "-" + (level+1) +  ",");
                        visited.add(newWord);
                    }

                }

            }
            System.out.println();
        }
        return 0;
    }

    public static void main(String[] args) {
        /*
         * beginWord = "hit",
         * endWord = "cog",
         * wordList = ["hot","dot","dog","lot","log","cog"]
         */
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int i = new Solution127().ladderLength("hit", "cog", wordList);
        System.out.println(i);
    }

}

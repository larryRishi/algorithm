package com.rishi.leetcode.bfs;

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


    /**
     * TODO 使用双向BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 扫描单词库，建立匹配符号
        Map<String, List<String>> allMatchers = buildMatchers(wordList);
        List<String> visited = new ArrayList<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Pair<String, Integer> root = new Pair<>(beginWord, 1);
        queue.offer(root);

        Queue<Pair<String, Integer>> tailQueue = new LinkedList<>();
        tailQueue.offer(new Pair<>(endWord, 1));
        // 广度优先搜索
        while (!queue.isEmpty() && !tailQueue.isEmpty()) {
            int size = queue.size();
            int tailSize = tailQueue.size();
            while (size-- > 0 ) {
                Pair<String, Integer> node = queue.poll();
                String key = node.getKey();
                for (int i = 0; i < key.length(); i++) {
                    String match = key.substring(0, i) + "*" + key.substring(i + 1);
                    List<String> matchers = allMatchers.getOrDefault(match, new ArrayList<>());
                    if (matchers.size() != 0) {
                        for (String find : matchers) {
                            if (visited.contains(find)) {
                                continue;
                            }
                            if (find.equals(endWord)) {
                                return node.getValue() + 1;
                            }
                            queue.offer(new Pair<>(find, node.getValue() + 1));
                            visited.add(find);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> buildMatchers(List<String> wordList) {
        Map<String, List<String>> matchers = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String match = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> ws = matchers.getOrDefault(match, new ArrayList<>());
                ws.add(word);
                matchers.put(match, ws);
            }
        });
        return matchers;
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

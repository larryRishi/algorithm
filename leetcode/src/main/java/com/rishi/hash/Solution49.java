package com.rishi.hash;

import java.util.*;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/group-anagrams/
 * @date 2019/10/21
 **/
public class Solution49 {

    /**
     * 总体时间复杂度：O(N*KlogK)
     * 空间复杂度O(K*N)
     * @param strs
     * @return
     */
    static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);//时间复杂度O(KlogK)
            String key = String.valueOf(chars);
            if(map.get(key) == null) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(strs[i]);

        }
        return new ArrayList(map.values());
    }


    /**
     * 时间复杂度O(K*N)
     * 空间复杂度O(K*N)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();
        for(String s : strs) {
            String key = hash(s);
            if(map.get(key) == null) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    /**
     * 时间复杂度O(K)
     *
     * @param s
     * @return
     */
    private String hash(String s) {
        int[] ints = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs) {
            ints[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(ints[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));

    }

}

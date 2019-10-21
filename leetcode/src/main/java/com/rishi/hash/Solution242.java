package com.rishi.hash;


import java.util.*;

/**
 * @author liuhx
 * @desc
 * @date 2019/10/21
 **/
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i = 0; i < sChars.length; i++) {
            map.put(sChars[i], map.get(sChars[i]) == null?1:(map.get(sChars[i]) + 1));
            map.put(tChars[i], map.get(tChars[i]) == null?-1:(map.get(tChars[i]) - 1));
        }
        for(Character c : map.keySet()) {
            if(map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 若有大小写的情况下
     * @param s
     * @param t
     * @return
     */
    static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        String s1 = s.toLowerCase();
        int[] tables = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tables[(s.charAt(i)<97?s.charAt(i) + 32:s.charAt(i))  - 'a']++;
            tables[(t.charAt(i)<97?t.charAt(i) + 32:t.charAt(i))  - 'a']--;
        }
        for(int num : tables) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }




}

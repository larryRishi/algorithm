package com.rishi.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/10
 **/
public class Solution387 {

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(new Solution387().firstUniqChar(str));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                Integer integer = map.get(s.charAt(i));
                map.put(s.charAt(i), ++integer);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return 0;
    }

}

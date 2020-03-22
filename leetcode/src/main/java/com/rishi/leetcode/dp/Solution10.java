package com.rishi.leetcode.dp;

/**
 * @author liuhx
 * @desc 正则表达式匹配
 * @date 2019/12/14
 **/
public class Solution10 {

    public static void main(String[] args) {
        String s = "aaa";
        String p = "a.,";
        System.out.println(new Solution10().isMatch3(s, p));
    }

    /**
     * 是否匹配，不带任意匹配符的情况下
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 是否匹配，带点的情况下
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int i = 0;
        int j = 0;
        while (j < p.length()) {
            if (i > s.length() - 1) {
                return false;
            }
            if (p.charAt(j) != '.' && s.charAt(i) != p.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    /**
     * 是否匹配，带点的情况下，转化成递归
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch3(String s, String p) {
        return helper(0, 0, s, p);
    }

    private boolean helper(int i, int j, String s, String p) {
        if (j == p.length()) {
            return true;
        }
        if (i == s.length()) {
            return false;
        }
        if (p.charAt(j) != '.' && s.charAt(i) != p.charAt(j)) {
            return false;
        }
        return helper(i + 1, j + 1, s, p);
    }


    /**
     * 带点还有带*的情况下
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch4(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        return true;
    }

}

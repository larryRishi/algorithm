package com.rishi.leetcode.string;

/**
 * @author liuhx
 * @desc 字符串匹配算法
 * @date 2019/12/14
 **/
public class StringMatches {

    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABDE";
        System.out.println(indexOf(str, p));
    }


    public static int indexOf(String str, String pat) {
        int m = str.length();
        int n = pat.length();
        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < pat.length(); j++) {
                if (str.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == pat.length()) {
                return i;
            }
        }

        return -1;
    }
}

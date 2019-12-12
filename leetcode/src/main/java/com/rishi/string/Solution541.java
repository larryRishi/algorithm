package com.rishi.string;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/11
 **/
public class Solution541 {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, chars.length - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "hellokitty";
        int k = 2;
        System.out.println(new Solution541().reverseStr(str, k));
        System.out.println('c' > 30);
    }

}

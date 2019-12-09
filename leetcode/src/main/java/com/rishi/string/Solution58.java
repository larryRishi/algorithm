package com.rishi.string;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/09
 **/
public class Solution58 {


    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("b a  "));
    }

    public int lengthOfLastWord(String s) {
        if (s != null && s.length() > 0) {
            int len = 0;
            int preLen = 0;
            for (int i = 0; i < s.length(); i++) {
                if (' ' == s.charAt(i)) {
                    preLen = len;
                    len = 0;
                } else {
                    len++;
                }
            }
            return preLen == 0 ? len:preLen;
        }
        return 0;

    }
}

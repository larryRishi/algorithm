package com.rishi.string;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/09
 **/
public class Solution709 {


    public static void main(String[] args) {
        System.out.println(new Solution709().toLowerCase("HeLlo"));
        String str = " ";
        String[] s = str.split(" ");
        System.out.println();
    }

    public String toLowerCase(String str) {
        if (str != null && str.length() > 0) {
            String ret = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 65 && c <= 90) {
                    c = (char)(c + 32);
                }
                ret += String.valueOf(c);
            }
            return ret;
        }
        return str;
    }
}

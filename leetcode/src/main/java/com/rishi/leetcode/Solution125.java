package com.rishi.leetcode;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/10/09
 **/
public class Solution125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        String filterS = s.replaceAll("[^A-Za-z0-9]", "");
        String palindromeS = new StringBuilder(filterS).reverse().toString();
        return filterS.equalsIgnoreCase(palindromeS);
    }

}

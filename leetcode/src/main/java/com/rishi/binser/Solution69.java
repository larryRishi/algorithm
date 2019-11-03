package com.rishi.binser;

/**
 * @author liuhx
 * @desc 求平方根
 * @date 2019/11/02
 **/
public class Solution69 {


    static int mySqrt(int x) {
        long left = 0;
        long right = x/2 + 1;//照顾x等于1的情况
        while (left < right) {
            long mid = left + ((right - left + 1) >>> 1);
            if (mid*mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}

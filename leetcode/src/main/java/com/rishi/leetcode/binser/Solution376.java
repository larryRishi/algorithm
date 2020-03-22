package com.rishi.leetcode.binser;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/wiggle-subsequence/
 * 摆动序列
 * @date 2019/11/02
 **/
public class Solution376 {

    static int wiggleMaxLength(int[] nums) {
        int max = 0;
        int preDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff == 0) {
                return 0;
            }
            if ((preDiff < 0 && diff < 0) || (preDiff > 0 && diff > 0)) {
                return 0;
            }
            if (diff < 0) {
                max = (0 - diff > max) ? (0 - diff) : max;
            } else {
                max = diff > max ? diff : max;
            }
            preDiff = diff;
        }
        return max;
    }


    public static void main(String[] args) {
        int i = -100;
        String s = String.valueOf(i);
        System.out.println(s);
    }

}

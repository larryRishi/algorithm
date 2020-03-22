package com.rishi.leetcode.array;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/10/13
 **/
public class Solution26 {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int base = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[base] != nums[i]) {
                nums[++base] = nums[i];
            }
        }
        return base+1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2,2};
        int i = removeDuplicates(nums);
        System.out.println(i);

    }
}

package com.rishi.leetcode.array;

/**
 * @author liuhx
 * @desc
 * @date 2019/10/16
 **/
public class Solution283 {

    /**
     * 先找出第一个0出现的索引位，往后遍历，若出现非零数字，
     * 覆盖第一个出现零的索引位，首个零索引位向前移动
     * 只会遍历一次数组，时间复杂度O(n),空间复杂度O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        int first0Index = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                first0Index = i;
                break;
            }
        }
        if(first0Index != -1) {
            for(int i = first0Index+1; i < nums.length; i++) {
                if(nums[i] != 0) {
                    nums[first0Index++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

}

package com.rishi.greed;

/**
 * @author liuhx
 * @desc
 * @date 2019/10/31
 **/
public class Solution45 {

    static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] >= nums.length - 1) {
            return 1;
        }
        int steps = 0;
        int i = 0;
        while (i < nums.length - 1) {
            int fallPoint = 0;
            int maxPoint = nums[i] + i;
            for (int j = i + 1; j <= maxPoint && j < nums.length; j++) {
                if (fallPoint <= nums[j] + j) {
                    fallPoint = nums[j] + j;
                    i = j;
                }
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,5,4,3};
        System.out.println(jump(nums));
    }

}

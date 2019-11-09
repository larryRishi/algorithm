package com.rishi.binser;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @date 2019/11/03
 **/
public class Solution153 {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(findMin(nums));
    }


    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
                System.out.println("mid:" + mid + ",left change to:" + left);
            } else {
                right = mid;
                System.out.println("mid:" + mid + ",right change to:" + right);
            }
        }
        return nums[left];
    }


}

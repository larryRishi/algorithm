package com.rishi.leetcode.binser;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/10
 **/
public class Solution34 {


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = new Solution34().searchRange(nums, target);
        for (int index : ints) {
            System.out.print(index + ",");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] defaultRet = {-1, -1};
        int leftBound = leftBound(nums, 0, nums.length - 1, target);
        if (leftBound == -1) {
            return defaultRet;
        }
        int rightBound = rightBound(nums, leftBound, nums.length - 1, target);
        return new int[]{leftBound, rightBound};
    }

    private int leftBound(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int rightBound(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

}

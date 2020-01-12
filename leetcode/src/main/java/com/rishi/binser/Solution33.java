package com.rishi.binser;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * @date 2019/11/02
 **/
public class Solution33 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int index = new Solution33().search(nums, 3);
        System.out.println(index);

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    }

    public int search(int[] nums, int target) {
        // 1. 利用二分法找到旋转点
        int p = findP(nums);
        // 2. 看target在那一边，继续二分法进行查找
        if (target == nums[p]) {
            return p;
        }
        if (p == 0) {
            return search(nums, 0, nums.length - 1, target);
        }
        if (target > nums[p] && target <= nums[nums.length - 1]) {
            return search(nums, p, nums.length - 1, target);
        } else {
            return search(nums, 0, p, target);
        }
    }

    private int search(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int findP(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return 0;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

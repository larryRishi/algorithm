package com.rishi.binser;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * @date 2019/11/02
 **/
public class Solution33 {


    static int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int unOrderPoint = findUnOrderPoint(nums);
        int i = binSearch(nums, 0, unOrderPoint - 1, target);
        int j = binSearch(nums, unOrderPoint, nums.length - 1, target);
        return i > j ? i : (i != j ? j : -1);
    }

    static int binSearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int move = findUnOrderPoint(nums);


        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int realIndex = (mid + move + nums.length) % nums.length;
            if (nums[realIndex] == target) {
                return realIndex;
            }
            if (nums[realIndex] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


    /**
     * 寻找无序处
     * @param nums
     * @return
     */
    static int findUnOrderPoint(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[right] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[right] < nums[right - 1]) {
            return right;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(search2(new int[]{3, 1,2}, 0));
    }

}

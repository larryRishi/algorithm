package com.rishi.leetcode.sort;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/03/21
 **/
public class Solution215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int kthLargest = new Solution215().findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return -1;
        }
        return quickSearch(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSearch(int[] nums, int begin, int end, int k) {
        int povit = povitFor(nums, begin, end);
        if (povit == k) {
            return nums[povit];
        }
        if (k > povit) {
            return quickSearch(nums, povit + 1, end, k);
        } else {
            return quickSearch(nums, begin, povit - 1, k);
        }
    }

    private int povitFor(int[] nums, int begin, int end) {
        int povit = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] > nums[povit]) {
                swap(nums, i, counter++);
            }
        }
        swap(nums, povit, counter);
        return counter;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

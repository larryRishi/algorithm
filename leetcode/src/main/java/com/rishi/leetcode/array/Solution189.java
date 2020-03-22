package com.rishi.leetcode.array;

/**
 * @author liuhx
 * @desc
 * @date 2019/10/16
 **/
public class Solution189 {

    /**
     * 时间复杂度O(k*n)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k = k%nums.length;
        while(k-- > 0) {
            int head = nums[nums.length - 1];
            for(int i = nums.length - 2; i>=0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = head;
        }
    }

    /**
     * 设数组长度为n
     * 已知我们将数组的任意元素向右移动k个位置，取模得知每个元素实际向右移动p = k%n 个位置
     * 其任意元素的最终位置为：(p+i)%n ==> ((k%n)+i)%n ==> (k+i)%n
     * 我们创建新数组，将其放置到最终位置即可。
     * -----------------------------
     * 时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        int[] a = new int[nums.length];
        System.arraycopy(nums, 0, a, 0, nums.length);
        for (int i = 0; i < a.length; i++) {
            nums[(k+i)%a.length] = a[i];
        }
    }
}

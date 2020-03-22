package com.rishi.leetcode.dp;

/**
 * @author liuhx
 * @desc 跳跃游戏
 * @date 2020/01/18
 **/
public class Solution55 {

    /**
     * 使用回溯算法来实现
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return canJumpEnd(0, nums);
    }

    private boolean canJumpEnd(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int jump = Math.min(nums[position] + position, nums.length - 1);
        for (int i = position + 1; i <= jump; i++) {
            if (canJumpEnd(i, nums)) {
                return true;
            }
        }
        return false;
    }


    //-----------------------------使用状态表 动态规划 自定向下-----------------------------------//

    /**
     * 动态规划，自顶向下
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        // 设置状态表dp(i)标识在索引i处，是否可以跳跃到末尾
        // dp(i) == 0 -> 未知
        // dp(i) == 1 -> 可以
        // dp(i) == 2 -> 不可以
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;

        return canJumpEnd2(0, nums, dp);
    }

    private boolean canJumpEnd2(int position, int[] nums, int[] dp) {

        int jump = Math.min(nums[position] + position, nums.length - 1);
        for (int i = jump; i >= position + 1; i--) {
            if (dp[i] == 0) {
                boolean b = canJumpEnd2(i, nums, dp);
                if (b) {
                    return true;
                } else {
                    dp[i] = 2;
                }

            } else if (dp[i] == 1) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }


    /**
     * 动态规划--自底向上
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        // 设置状态表dp(i)标识在索引i处，是否可以跳跃到末尾
        // dp(i) == 0 -> 未知
        // dp(i) == 1 -> 可以
        int canJumpEndPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (canJumpEndPos - i <= nums[i]) {
                canJumpEndPos = i;
            }
        }

        return canJumpEndPos == 0;
    }



}

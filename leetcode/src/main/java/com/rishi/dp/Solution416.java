package com.rishi.dp;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/18
 **/
public class Solution416 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new Solution416().canPartition(nums));
        System.out.println("----");
        System.out.println(new Solution416().canPartition2(nums));
    }


    public boolean canPartition(int[] nums) {
        // 0-1 背包问题
        // dp(i, j) i表示针对第i个物品，j表示不放入背包或者放入背包后，背包中物品容量总和
        // 计算数组和，
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int halfSum = sum / 2;
        boolean[][] states = new boolean[nums.length][halfSum + 1];
        states[0][0] = true;
        if (nums[0] <= halfSum) {
            states[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= halfSum; j++) {
                // 不放入背包
                states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= halfSum - nums[i]; j++) {
                // 放入背包
                if (states[i - 1][j])
                    states[i][j + nums[i]] = true;
            }

            if (states[i][halfSum]) {
                return true;
            }
        }
        return false;
    }


    public boolean canPartition2(int[] nums) {
        // 0-1 背包问题
        // dp(i, j) i表示针对第i个物品，j表示不放入背包或者放入背包后，背包中物品容量总和
        // 计算数组和，
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int halfSum = sum / 2;
        boolean[] states = new boolean[halfSum + 1];
        states[0] = true;
        if (nums[0] <= halfSum) {
            states[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = halfSum - nums[i]; j >= 0; j--) {
                // 放入背包
                if (states[j])
                    states[j + nums[i]] = true;
            }
            if (states[halfSum]) {
                return true;
            }
        }
        return false;
    }
}

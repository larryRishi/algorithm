package com.rishi.divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/subsets/
 * @date 2019/10/24
 **/
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        divide(0, nums, new ArrayList<>());
        return ans;
    }

    private void divide(int i, int[] nums, List<Integer> list) {
        if (i == nums.length) {
            System.out.println(list);
            return;
        }
        divide(i + 1, nums, list);//not fill
        list.add(nums[i]);
        divide(i + 1, nums, list);//fill
        //list.remove(list.size()-1);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution78().subsets(nums);

    }


}

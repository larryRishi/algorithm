package com.rishi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/03
 **/
public class Solution77 {


    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4, 2));
    }


    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans, k);
        return ans;
    }

    private void backtrack(int n, int[] nums, List<Integer> list, List<List<Integer>> ans, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = n; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, nums, list, ans, k);
            list.remove(list.size() - 1);
        }
    }

}

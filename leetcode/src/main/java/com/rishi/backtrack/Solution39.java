package com.rishi.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/03
 **/
public class Solution39 {


    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(new Solution39().combinationSum(candidates, target));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, candidates.length, new ArrayList<>(), ans, 0, 0, target);
        return ans;
    }

    private void backtrack(int n, int[] candidates, int len, List<Integer> list, List<List<Integer>> ans, int currentSum, int upValue, int target) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = n; i < len; i++) {

            list.add(candidates[i]);
            backtrack(i, candidates, len, list, ans, currentSum + candidates[i], candidates[i], target);
            list.remove(list.size() - 1);
        }
    }
}

package com.rishi.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhx
 * @desc 全排列问题
 * https://leetcode-cn.com/problems/permutations/
 * @date 2019/11/9
 **/
public class Solution46 {


    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution46.permute(nums));
        System.out.println("----");
        System.out.println(System.getProperty("sun.arch.data.model"));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        generate(0, nums, nums.length, visited, new ArrayList<>(), ans);
        return ans;
    }

    private void generate(int n, int[] nums, int length, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
        if (n == length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                generate(n + 1, nums, length, visited, list, ans);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }

}

package com.rishi.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/10/15
 **/
public class Solution15 {


    public static void main(String[] args) {
        int[] array = {-4,-2,-1,0,1,2};
        List<List<Integer>> lists = threeSum(array);
        System.out.println(lists);
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0) {
                break;
            }
            if(k>0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k+1;
            int j = nums.length - 1;
            while(i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if(s == 0) {
                    retList.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i<j &&nums[j] == nums[--j]);
                    while(i<j && nums[i] == nums[++i]);

                } else if (s > 0) {
                    while(i<j && nums[j] == nums[--j]);
                } else{
                    while(i<j && nums[i] == nums[++i]);
                }
            }
        }
        return retList;
    }

}

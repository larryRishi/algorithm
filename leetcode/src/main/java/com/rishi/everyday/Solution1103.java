package com.rishi.everyday;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/03/05
 **/
public class Solution1103 {

    public static void main(String[] args) {
        new Solution1103().distributeCandies(10, 3);
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int r = 0;
        for (int i = 0; i < num_people; i++) {
            if (candies >= i + 1 + r * num_people) {
                ans[i] += i + 1 + r * num_people;
                candies -= i + 1 + r * num_people;
            } else {
                ans[i] += candies;
                candies = 0;
            }
            if (candies > 0 && i == num_people - 1) {
                r++;
                // 重置i
                i = -1;
            }
        }
        return ans;
    }

}

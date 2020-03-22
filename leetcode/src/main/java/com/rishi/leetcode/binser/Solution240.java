package com.rishi.leetcode.binser;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/10
 **/
public class Solution240 {

    public static void main(String[] args) {
        /*int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };*/

        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        int target = 5;
        boolean b = new Solution240().searchMatrix(matrix, target);
        System.out.println(b);
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int colIndex = search(matrix[0], target, true);
        if (matrix[0][colIndex] == target) {
            return true;
        }
        int[] col = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            col[i] = matrix[i][colIndex];
        }
        int rowIndex = search(col, target, false);
        return rowIndex != -1;
    }


    /**
     * flag为true时有目标就返回目标，没目标就返回最接近它的值
     **/
    private int search(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left + 1) >> 1;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return flag ? left : -1;
    }

}

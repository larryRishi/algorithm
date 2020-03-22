package com.rishi.leetcode.sort;

import static com.rishi.leetcode.sort.CommonUtils.print;

/**
 * @author liuhx
 * @desc
 * @date 2019/12/01
 **/
public class Solution1122 {


    public static void main(String[] args) {
        /**
         * [2,3,1,3,2,4,6,7,9,2,19, 12]
         * [2,1,4,3,9,6]
         */

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19, 12};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] ints = new Solution1122().relativeSortArray(arr1, arr2);
        print(ints);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int min = arr1[0];
        int max = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            min = Math.min(min, arr1[i]);
            max = Math.max(max, arr1[i]);
        }
        int[] temp = new int[max - min + 1];
        //填充计数
        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i] - min]++;
        }
        //冲arr2中获取填充至arr1中
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (temp[arr2[i] - min]-- > 0) {
                arr1[index++] = arr2[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- > 0) {
                arr1[index++] = i + min;
            }
        }
        return arr1;
    }


}

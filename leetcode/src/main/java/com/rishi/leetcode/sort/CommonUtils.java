package com.rishi.leetcode.sort;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/01
 **/
public class CommonUtils {


    //--------------------------工具method--------------------------


    public static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }


    public static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + ", ");
        }
    }

}

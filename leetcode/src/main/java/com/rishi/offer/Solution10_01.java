package com.rishi.offer;

import java.util.Stack;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/03/03
 **/
public class Solution10_01 {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        new Solution10_01().merge(A, 3, B, 3);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int ai = 0, bi = 0;
        for (int i = 0; i < m + n; i++) {
            if (ai < m && bi < n) {
                if (A[ai] < B[bi]) {
                    temp[i] = A[ai++];
                } else {
                    temp[i] = B[bi++];
                }
            } else {
                if (ai < m) {
                    temp[i] = A[ai++];
                }
                if (bi < n) {
                    temp[i] = B[bi++];
                }
            }
        }
        for (int i = 0; i < m + n; i++) {
            A[i] = temp[i];
        }
    }

}

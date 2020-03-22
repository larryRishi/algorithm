package com.rishi.leetcode.sort;

/**
 * @author liuhx
 * @desc 各种排序算法
 * @date 2020/03/21
 **/
public class Sort2 {

    public static void main(String[] args) {
        int[] array = {3, 4,1, 5, 2, 12, 6};
        new Sort2().quickSort(array);
        CommonUtils.print(array);
    }


    /**
     * 快排
     * @param arrays
     */
    public void quickSort(int[] arrays) {
        doQuickSort(arrays, 0, arrays.length - 1);
    }

    private void doQuickSort(int[] arrays, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = pivotFor(arrays, begin, end);
        doQuickSort(arrays, begin, pivot - 1);
        doQuickSort(arrays, pivot + 1, end);
    }

    private int pivotFor(int[] arrays, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arrays[i] < arrays[pivot]) {
                CommonUtils.swap(arrays, i, counter++);
            }
        }
        CommonUtils.swap(arrays, counter, pivot);
        return counter;
    }

    //------------------------

    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    public void mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        //合并操作
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }



    // ----------------非比较排序----------------

    public void countingSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }

    }
}

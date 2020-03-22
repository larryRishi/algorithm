package com.rishi.leetcode.sort;


import static com.rishi.leetcode.sort.CommonUtils.print;
import static com.rishi.leetcode.sort.CommonUtils.swap;

/**
 * @author liuhx
 * @desc 选择排序
 * @date 2019/11/30
 **/
public class Sort {

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 6, 5, 2, 8, 7, 9};


        //new Sort().selectSort(array);
        //new Sort().bubbleSort(array);
        //new Sort().insertSort(array);
        //new Sort().quickSort(array);
        //new Sort().mergeSort(array, 0, 8);
        int i = new Sort().quickSortFindK(array, 3);
        System.out.println(i);

        print(array);
    }


    //---------------------非比较排序之计数排序--------------

    /**
     * 计数排序
     *
     * @param a
     */
    public int[] countingSort(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        int[] sortedArray = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            sortedArray[a[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            while (sortedArray[i] > 0) {
                a[index++] = i + min;
                sortedArray[i]--;
            }
        }
        return a;
    }


    //-------------------------比较排序之高级排序---------------------------------

    /**
     * 归并排序
     * 时间复杂度为O(logN)
     *
     * @param array
     * @param left
     * @param right
     */
    public void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        //合并
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


    /**
     * 快排
     * 时间复杂度：O(logN)
     * 空间复杂度为：O(logN)
     *
     * @param arrays
     */
    public void quickSort(int[] arrays) {
        int begin = 0;
        int end = arrays.length - 1;
        helper(arrays, begin, end);
    }

    private void helper(int[] arrays, int begin, int end) {
        if (begin >= end) {
            return;
        }
        //当前逻辑
        int pivot = pivotFor(arrays, begin, end);
        //下探操作
        helper(arrays, begin, pivot - 1);
        helper(arrays, pivot + 1, end);
    }

    /**
     * 确定基准
     *
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    private int pivotFor(int[] arrays, int begin, int end) {
        int counter = begin;
        int pivot = end;
        for (int i = begin; i < end; i++) {
            if (arrays[i] < arrays[pivot]) {
                swap(arrays, i, counter++);
            }
        }
        swap(arrays, counter, pivot);
        return counter;
    }


    //----------------------比较排序之初级排序--------------------------------

    /**
     * 插入排序
     * 时间复杂度为O(N^2)
     * 稳定的排序
     *
     * @param arrays
     */
    public void insertSort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int preIndex = i - 1;
            int current = arrays[i];
            while (preIndex >= 0 && arrays[preIndex] > current) {
                arrays[preIndex + 1] = arrays[preIndex];
                preIndex--;
            }
            arrays[preIndex + 1] = current;
        }
    }


    /**
     * 冒泡排序
     * 时间复杂度为O(N^2)
     * 最好的时间复杂度为O(N)
     *
     * @param arrays
     */
    public void bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    swap(arrays, j, j + 1);
                }
            }
        }
    }


    /**
     * 选择排序，时间复杂度为O(N^2)
     *
     * @param array
     */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            //寻找最小值
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //交换当前索引i与最小索引
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }



    //---------------------------------------------------------------------

    /**
     * 利用快排确定第K大元素
     * 时间复杂度：O(logN)
     * 空间复杂度为：O(logN)
     *
     * @param arrays
     */
    public int quickSortFindK(int[] arrays, int k) {
        int begin = 0;
        int end = arrays.length - 1;
        return helper2(arrays, begin, end, k);
    }

    private int helper2(int[] arrays, int begin, int end, int k) {
        if (begin >= end) {
            return arrays[begin];
        }
        //当前逻辑
        int pivot = pivotFor2(arrays, begin, end);
        if (pivot + 1 == k) {
            return arrays[pivot];
        }
        if (pivot + 1 > k) {
            return helper2(arrays, begin, pivot - 1, k);
        } else {
            return helper2(arrays, pivot + 1, end, k);
        }


    }

    /**
     * 确定基准
     *
     * @param arrays
     * @param begin
     * @param end
     * @return
     */
    private int pivotFor2(int[] arrays, int begin, int end) {
        int counter = begin;
        int pivot = end;
        for (int i = begin; i < end; i++) {
            if (arrays[i] < arrays[pivot]) {
                swap(arrays, i, counter++);
            }
        }
        swap(arrays, counter, pivot);
        return counter;
    }

}

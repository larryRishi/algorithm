package com.rishi.geek.search;

/**
 * @author liuhx
 * @desc 二分法实现
 * @date 2019/4/25
 **/
public class BSearch {

    /**
     * 二分法查找元素，返回元素下标，没有则返回-1
     *
     * @param array
     * @param val
     * @return
     */
    public static int bsearch(int[] array, int val) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int midIndex = (low + high) / 2;
            if (val == array[midIndex]) {
                return midIndex;
            } else if (val > array[midIndex]) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }

        return -1;
    }


    /**
     * 使用递归实现二分法
     *
     * @param array
     * @param low
     * @param high
     * @param val
     * @return
     */
    public static int bsearch2(int[] array, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (val == array[mid]) {
            return mid;
        } else if (val > array[mid]) {
            return bsearch2(array, mid + 1, high, val);
        } else {
            return bsearch2(array, low, mid - 1, val);
        }

    }

    /**
     * 利用二分法求平方根
     *
     * @param x
     * @return
     */
    public static int sqilt(int x) {
        int low = 0;
        return do_sqilt(low, x, x);
    }

    private static int do_sqilt(int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        int nowVal = mid * mid;
        if (x == nowVal) {
            return mid;
        } else if (x > nowVal) {
            return do_sqilt(mid + 1, (mid + (high - mid) / 2), x);
        } else {
            return do_sqilt((low + (mid - low) / 2), mid - 1, x);
        }
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 5, 6, 7, 8, 12, 13, 15, 45};
        System.out.println(bsearch(array, 12));

        System.out.println(bsearch2(array, 0, array.length - 1, 14));

        System.out.println(sqilt(5));

    }

}

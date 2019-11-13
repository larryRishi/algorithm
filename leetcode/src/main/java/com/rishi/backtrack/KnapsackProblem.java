package com.rishi.backtrack;


/**
 * @author liuhx
 * @desc 背包问题
 * 限定盛放物品的容器，问给定一些物品，背包中能够存放物品的最大重量
 * @date 2019/11/11
 **/
public class KnapsackProblem {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] mem = new int[]{2, 2, 4, 6, 3};
        int w = 9;
        maxW2(w, mem);
        System.out.println(max);
    }

    static void maxW(int w, int[] mem) {
        f(0, mem, mem.length, w, 0);
    }

    /**
     * 代码中含有冗余的状态量
     *
     * @param i
     * @param mem
     * @param size
     * @param w
     * @param currentW
     */
    static void f(int i, int[] mem, int size, int w, int currentW) {
        if (i == size || currentW == w) {
            max = max > currentW ? max : currentW;
            return;
        }
        //选择不装第i个物品
        f(i + 1, mem, size, w, currentW);
        if (currentW + mem[i] <= w) {
            f(i + 1, mem, size, w, currentW + mem[i]);
        }
    }


    ////////////////////////////////////////////////////////////////////////

    /**
     * 排除冗余的过程量
     *
     * @param w
     * @param mem
     */
    static void maxW2(int w, int[] mem) {
        boolean[][] booleans = new boolean[mem.length][w + 1];
        f2(0, mem, mem.length, w, 0, booleans);
    }

    static void f2(int i, int[] mem, int size, int w, int currentW, boolean[][] booleans) {
        if (i == size || currentW == w) {
            max = max > currentW ? max : currentW;
            return;
        }
        //选择不装第i个物品
        if (booleans[i][currentW]) {
            return;
        }
        f2(i + 1, mem, size, w, currentW, booleans);
        if (currentW + mem[i] <= w) {
            f2(i + 1, mem, size, w, currentW + mem[i], booleans);
        }
    }
}

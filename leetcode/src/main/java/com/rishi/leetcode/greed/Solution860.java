package com.rishi.leetcode.greed;

/**
 * @author liuhx
 * @desc
 * @date 2019/10/31
 **/
public class Solution860 {

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }

    static boolean lemonadeChange(int[] bills) {
        //记录收取的零钱余额
        //位置0存储5元，1存储10元
        int[] moneyPackage = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                moneyPackage[0]++;
            } else if (bills[i] == 10) {
                moneyPackage[1]++;
                if (moneyPackage[0] == 0) {
                    return false;
                }
                moneyPackage[0]--;
            } else {
                if (moneyPackage[1] >= 1 && moneyPackage[0] >= 1) {
                    moneyPackage[0]--;
                    moneyPackage[1]--;
                } else if (moneyPackage[0] >= 3) {
                    moneyPackage[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}

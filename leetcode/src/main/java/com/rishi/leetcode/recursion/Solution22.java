package com.rishi.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhx
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019/10/22
 **/
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0,n, "", ans);
        return ans;
    }

    private void generate(int left, int right, int max, String s, List<String> ans) {
        // return condition
        if (left == max && right == max) {
            ans.add(s);
            return;
        }

        //process current logic

        //dill down


        if (left > right) {
            generate(left, right + 1, max, s + ")", ans);
        }
        if (left < max) {
            generate(left + 1, right, max, s + "(", ans);
        }


        //restore current status
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }

}

package com.rishi.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @date 2019/10/23
 **/
public class Solution589 {

    /**
     * 使用栈模拟递归调用
     * 时间复杂度为O(N)
     * 空间复杂度为O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                ans.add(node.val);
                List<Node> children = node.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return ans;
    }


}

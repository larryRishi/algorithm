package com.rishi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * @date 2019/10/23
 **/
public class Solution590 {

    /**
     * 模拟栈来调用，只需要按照“current-right-left"放入链表头部就行
     * 取栈顶元素为当前结点，取其左右先后放入栈中，周而复始直至栈为空
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                ans.add(0, node.val);
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        return ans;
    }

}

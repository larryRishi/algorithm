package com.rishi.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * @date 2019/10/23
 **/
public class Solution94 {


    /**
     * 迭代方式完成
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            root = node.right;
        }
        return ans;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            System.out.println("current node is null,return ");
            return;
        }
        System.out.println("current node:"+root.val+",goto left");
        helper(root.left, ans);
        System.out.println("add current node:"+root.val);
        ans.add(root.val);
        System.out.println("current node:"+root.val+",goto right");
        helper(root.right, ans);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(20);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        new Solution94().inorderTraversal(root);
    }
}

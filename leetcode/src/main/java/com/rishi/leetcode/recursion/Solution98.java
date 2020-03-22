package com.rishi.leetcode.recursion;

import com.rishi.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @date 2019/10/23
 **/
public class Solution98 {

    private TreeNode pre = null;


    public boolean isVailBST2 (TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre2 = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre2 != null && pre2.val >= node.val) {
                return false;
            }
            pre2 = node;
            root = node.right;
        }
        return true;
    }


    //递归方式完成
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    //使用中序遍历（左-中-右）
    private boolean inOrder(TreeNode root) {
        if (root == null) {
            System.out.println("终止");
            return true;
        }
        System.out.println("压栈：" + root.val);
        if (!inOrder(root.left)) {
            return false;
        }
        System.out.println("当前结点：" + root.val + ",pre结点：" + (pre == null ? null : pre.val));
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        System.out.println("当前结点"+root.val+"作为pre结点");
        pre = root;
        return inOrder(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new Solution98().isVailBST2(root));
    }

}

package com.rishi.leetcode.recursion;

import com.rishi.leetcode.tree.TreeNode;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/invert-binary-tree/description/
 * @date 2019/10/22
 **/
public class Solution226 {


    public TreeNode invertTree(TreeNode root) {
        // return condition
        if (root == null) {
            return null;
        }

        // dill down
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);


        // process current logic
        root.left = right;
        root.right = left;

        return root;
    }




}

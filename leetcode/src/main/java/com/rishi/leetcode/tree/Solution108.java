package com.rishi.leetcode.tree;

/**
 * @author liuhx
 * @desc 将有序数组转化为平衡二叉树
 * @date 2019/12/16
 **/
public class Solution108 {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return initTreeNode(0, nums.length - 1, nums);
    }

    private TreeNode initTreeNode(int left, int right, int[] nums) {
        if (left == right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(mid);
        node.left = initTreeNode(left, mid, nums);
        node.right = initTreeNode(mid + 1, right, nums);
        return node;
    }
    
}

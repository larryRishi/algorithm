package com.rishi.leetcode.divide;

import com.rishi.leetcode.tree.TreeNode;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/06
 **/
public class Solution105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new Solution105().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            throw new RuntimeException("Ill");
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode node = new TreeNode(pivot);
        int inPovitIndex = inLeft;
        while (inorder[inPovitIndex] != pivot) {
            inPovitIndex++;
        }
        node.left = buildTree(preorder, preLeft + 1, inPovitIndex - inLeft + preLeft,
                inorder, inLeft, inPovitIndex - 1);
        node.right = buildTree(preorder, inPovitIndex - inLeft + preLeft + 1, preRight,
                inorder, inPovitIndex + 1, inRight);
        return node;
    }

}

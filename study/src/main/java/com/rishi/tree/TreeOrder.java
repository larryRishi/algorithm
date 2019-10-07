package com.rishi.tree;



/**
 * @author liuhx
 * @desc 树的各种排序
 * @date 2019/10/06
 **/
public class TreeOrder {

    /**
     * 中序遍历（左-中-右）
     * @param root
     */
    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+"-");
        inOrder(root.right);
    }

    /**
     *               1
     *             /  \
     *           2     3
     *          / \   / \
     *         4  5  8  9
     *       /  \  \
     *      6   7  10
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        inOrder(root);
    }

}

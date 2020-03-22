package com.rishi.leetcode.tree;

/**
 * @author liuhx
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019/10/07
 **/
public class Solution98 {

    static TreeNode pre;

    static boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    //左-中-右
    static boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inOrder(root.left)) {
            return false;
        }
        if (pre != null && pre.val>root.val) {
            return false;
        }
        pre = root;
        return inOrder(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(6);

        root.right = new TreeNode(18);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(20);
        System.out.println(isValidBST(root));
    }

}

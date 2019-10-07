package com.rishi.tree;

/**
 * @author liuhx
 * @desc trie工具
 * @date 2019/09/30
 **/
public class NodeUtils {


    /**
     * 按层遍历二叉树
     */
    public static void floorOrder() {

    }


    /**
     * 前序遍历 （当前结点-left结点-right结点）
     * @param node
     */
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "-");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历（left结点--当前结点--right结点）
     * @param node
     */
    public static void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.print(node.val + "-");
        midOrder(node.right);
    }


    /**
     * 后序遍历（left结点--right结点--当前结点）
     * @param node
     */
    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        midOrder(node.right);
        System.out.print(node.val + "-");
    }
}

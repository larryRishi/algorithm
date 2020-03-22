package com.rishi.leetcode.node;

import com.rishi.leetcode.tree.TreeNode;
import com.rishi.leetcode.tree.NodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liuhx
 * @desc NodeTest
 * @date 2019/09/30
 **/
public class NodeTest {

    TreeNode root = null;



    @Test
    public void testPreOrder() {
        NodeUtils.preOrder(root);
    }

    @Test
    public void testMidOrder() {
        NodeUtils.midOrder(root);
    }

    @Test
    public void testPostOrder() {
        NodeUtils.postOrder(root);
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
    @Before
    public void init() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
    }
}

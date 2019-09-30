package com.rishi.node;

import com.rishi.tree.Node;
import com.rishi.tree.NodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liuhx
 * @desc NodeTest
 * @date 2019/09/30
 **/
public class NodeTest {

    Node root = null;



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


    @Before
    public void init() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.left.right.right = new Node(10);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
    }
}

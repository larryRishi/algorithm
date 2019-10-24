package com.rishi.tree;

import java.util.List;

/**
 * @author liuhx
 * @desc
 * @date 2019/10/23
 **/
public class Node {

    public int val;
    public List<Node> children;

    public Node(int i) {
        this.val = i;
    }

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

}

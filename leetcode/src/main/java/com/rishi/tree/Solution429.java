package com.rishi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @date 2019/10/23
 **/
public class Solution429 {


    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                while (size-- > 0){
                    Node node = queue.poll();
                    list.add(node.val);
                    if (node.children.size() > 0) {
                        for (Node child : node.children) {
                            queue.offer(child);
                        }
                    }

                }
                ans.add(list);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Node node = new Node(1, new ArrayList<>());
        List<Node> children = new ArrayList<>();
        node.children = children;
        Node node1 = new Node(3, new ArrayList<>());
        children.add(node1);
        children.add(new Node(2, new ArrayList<>()));
        children.add(new Node(4, new ArrayList<>()));
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5, new ArrayList<>()));
        children2.add(new Node(6, new ArrayList<>()));
        node1.children = children2;

        System.out.println(levelOrder(node));

    }

}

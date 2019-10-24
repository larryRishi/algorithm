package com.rishi.tree;

import java.util.*;

/**
 * @author liuhx
 * @desc https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @date 2019/10/23
 **/
public class Solution297 {


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println();
    }

}


/**
 * v1 超出时间限制
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //按层遍历，放置在list中
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            //求最大深度
            int i = maxDepth(root);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (i-- > 0) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    list.add(node == null ? null : node.val);
                    queue.offer(node == null ? null : node.left);
                    queue.offer(node == null ? null : node.right);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, root);
        for (int i = 1; i < array.length; i++) {
            int k = (i - 1) >>> 1;
            TreeNode node = map.get(k);
            TreeNode child = array[i].equals("null") ? null : new TreeNode(Integer.valueOf(array[i]));
            if (node != null) {
                if ((i - 1) % 2 == 0) {
                    node.left = child;
                } else {
                    node.right = child;
                }
            }

            map.put(i, child);
        }
        return root;
    }


    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
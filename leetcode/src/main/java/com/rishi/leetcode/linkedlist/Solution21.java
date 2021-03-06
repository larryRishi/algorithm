package com.rishi.leetcode.linkedlist;

import com.rishi.leetcode.list.ListNode;

/**
 * @author liuhx
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * @date 2019/9/19
 **/
public class Solution21 {

    /**
     * 使用迭代法
     * 链表的好处就是可以随意操作引用，我们定义两个指针，在l1和l2链表上进行移动比较
     * 1 -> 2 -> 4       1 -> 3 -> 4
     * ^                 ^
     * l1                l2
     *
     * 定义哨兵结点用于连接l1和l2指针移动时较小的结点
     * +--------+
     * |sentinel| ->
     * +-------+
     *     ^
     *    cur
     * 两条链终止的条件为至少有一条链移至链尾，若还有其中一条链指针未移至链尾，将其连接至cur.next处即可
     *
     * 时间复杂度：O(m+n);空间复杂度O(1)
     * @param l1
     * @param l2
     * @return
     */
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return sentinel.next;
    }


    /**
     * 使用递归
     * 时间复杂度为O(m+n),压栈需要空间为O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.printList();
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        head2.printList();
        mergeTwoLists2(head, head2).printList();
    }

}

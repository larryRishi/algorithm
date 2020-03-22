package com.rishi.leetcode.linkedlist;

import com.rishi.leetcode.list.ListNode;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/9/27
 **/
public class Solution00 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head, 5).printList();
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel, cur = head;
        int i = 0;
        while (i++ < n && cur != null) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return sentinel.next;
    }
}

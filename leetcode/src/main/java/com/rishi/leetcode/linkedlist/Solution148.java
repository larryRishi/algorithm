package com.rishi.leetcode.linkedlist;

import com.rishi.leetcode.list.ListNode;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/01/04
 **/
public class Solution148 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        new Solution148().sortList(head).printList();
    }

    public ListNode sortList(ListNode head) {
        // 采用分治的思想解决，模仿归并排序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode sentinel = new ListNode(-1);
        ListNode pre = sentinel;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if (left != null) {
            pre.next = left;
        }
        if (right != null) {
            pre.next = right;
        }
        return sentinel.next;
    }


}

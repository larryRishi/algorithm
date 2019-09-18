package com.rishi.linkedlist;

import com.rishi.list.ListNode;

/**
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author liuhx
 * @desc 反转链表II
 * @date 2019/9/18
 **/
public class Solution92 {

    static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mNode = head;
        ListNode mPre = null;
        ListNode pre = null;
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            ++index;
            if (index > m && index <= n) {
                pre.next = cur.next;
                cur.next = mNode;
                if (mPre != null) {
                    mPre.next = cur;
                } else {
                    head = cur;
                }
                mNode = cur;
                cur = pre.next;
            } else {
                if (index == m) {
                    mNode = cur;
                }
                if (index+1 == m) {
                    mPre = cur;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head.printList();
        System.out.println("========================");
        reverseBetween(head, 1, 2).printList();
    }

}

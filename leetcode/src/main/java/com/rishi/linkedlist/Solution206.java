package com.rishi.linkedlist;

import com.rishi.list.ListNode;

/**
 * @author liuhx
 * @desc 反转链表
 * @date 2019/9/16
 **/
public class Solution206 {

    /**
     * 迭代法
     * 暴力破解，会创建新的对象，不是真正的反转
     * @param head
     * @return
     */
    static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        for (ListNode node = head; node != null; node = node.next) {
            ListNode listNode = new ListNode(node.val);
            listNode.next = newHead;
            newHead = listNode;
        }
        return newHead;
    }


    static ListNode reverseList2(ListNode head) {
        ListNode newHead = head;
        if (head != null) {
            while (head.next != null) {
                ListNode temp = head.next;
                head.next = head.next.next;
                temp.next = newHead;
                newHead = temp;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.printList();
        System.out.println("reverseList:");
        reverseList(head).printList();
        System.out.println("reverseList2:");
        reverseList2(head).printList();
    }

}

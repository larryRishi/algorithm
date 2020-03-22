package com.rishi.leetcode.linkedlist;

import com.rishi.leetcode.list.ListNode;

/**
 * @author liuhx
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * @date 2019/9/18
 **/
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null && head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        //中点
        for (ListNode node = fast; node != null; node = fast.next.next) {
            slow = slow.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head.printList();
    }

}

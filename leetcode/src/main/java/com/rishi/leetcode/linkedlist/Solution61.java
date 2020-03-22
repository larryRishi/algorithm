package com.rishi.leetcode.linkedlist;

import com.rishi.leetcode.list.ListNode;

/**
 * @author liuhx
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019/09/30
 **/
public class Solution61 {

    static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        //先将其构建成首尾连接的环
        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            len++;
            cur = cur.next;
        }
        cur.next = head;

        //在环上移动
        int mv = 0;
        int round = k%len;
        if(round != 0) {
            mv = len - round;
        }
        ListNode pre = cur,newHead = head;
        while(mv > 0) {
            pre = pre.next;
            newHead = newHead.next;
            mv--;
        }
        pre.next = null;
        return newHead;
    }


}

package com.rishi.list;


public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void printList() {
        System.out.print(val+"->");
        for (ListNode node = next; node != null; node = node.next) {
            System.out.print(node.val + "->");
        }
        System.out.println();
    }
}
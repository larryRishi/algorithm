package com.rishi.linkedlist.lru;

import com.rishi.linkedlist.ListNode;

/**
 * 实现LRU链表
 *
 * 维护一个有序单链表，越靠近尾部的结点是越早之前访问的。
 * 当有一个新的数据被访问时，我们从链表头开始顺序遍历链表
 *
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部
 *
 * 2， 如果此数据没有在缓存链表中，又可以分为两种情况：
 *  （1）如果此时缓存未满，则将此节点直接插入链表头部
 *  （2）如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表头
 *
 */
public class MokeLru {

    /**
     * 头结点
     */
    private ListNode head;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 当前长度
     */
    private int currentSize;

    public MokeLru(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("容量不能小于等于0");
        }
        this.capacity = capacity;
    }

    public void add(int x){
        if (head == null) {
            head = new ListNode(x);
            currentSize++;
        } else {
            ListNode preNode = null;//记录前一结点
            //查看元素是否存在链表中
            for (ListNode node = head; node != null; node = node.next){
                //存在结点
                if (x == node.val) {
                    if (preNode != null) {
                        preNode.next = node.next;
                        node.next = head;
                        head = node;
                    }
                    return;
                }
                preNode = node;
            }

            //不存在结点
            if (isFull()) {
                ListNode preNode2 = null;
                for (ListNode node = head; node != null; node = node.next){
                    if (node.next == null) {
                        if (preNode2 != null) {
                            preNode2.next = null;
                        }
                        break;
                    }
                    preNode2 = node;
                }
            } else {
                currentSize++;
            }
            add2Head(x);
        }
    }

    /**
     * add2Head
     * @param x
     */
    private void add2Head(int x) {
        ListNode newHead = new ListNode(x);
        newHead.next = head;
        head = newHead;
    }

    /**
     * 链表是否已满
     * @return
     */
    private boolean isFull(){
        return this.capacity == this.currentSize;
    }

    public void printListNode(){
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MokeLru lru = new MokeLru(5);
        lru.add(1);
        lru.printListNode();
        lru.add(2);
        lru.printListNode();
        lru.add(3);
        lru.printListNode();
        lru.add(4);
        lru.printListNode();
        lru.add(5);
        lru.printListNode();
        lru.add(2);
        lru.printListNode();
        lru.add(2);
        lru.printListNode();
        lru.add(3);
        lru.printListNode();
    }
}

package com.rishi.leetcode.queue;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/10/17
 **/
public class MyCircularDeque {

    private int[] array;
    private int headIndex;
    private int tailIndex;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if(!isFull()) {
            if(headIndex == 0) {
                for(int i = tailIndex; i >= 0; i--) {
                    array[i+1] = array[i];
                }
                tailIndex++;
                array[headIndex] =  value;
            } else {
                array[--headIndex] = value;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(!isFull()) {
            if (isEmpty()) {
                headIndex = tailIndex = array.length - 1;
                array[tailIndex] = value;
                size++;
                return true;
            }
            if(tailIndex == array.length - 1) {
                for(int i = headIndex; i < array.length; i++) {
                    array[i-1] = array[i];
                }
                headIndex--;
                array[array.length - 1] = value;
            } else {
                array[++tailIndex] = value;
            }
            size++;
            return true;
        }
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(!isEmpty()) {
            headIndex++;
            size--;
            return true;
        }
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(!isEmpty()) {
            tailIndex--;
            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(!isEmpty()) {
            return array[headIndex];
        }
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(!isEmpty()) {
            return array[tailIndex];
        }
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == array.length;
    }

}

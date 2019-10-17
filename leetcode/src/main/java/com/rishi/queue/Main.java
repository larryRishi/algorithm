package com.rishi.queue;

import java.util.PriorityQueue;

/**
 * @author liuhx
 * @desc Main
 * @date 2019/10/16
 **/
public class Main {


    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}

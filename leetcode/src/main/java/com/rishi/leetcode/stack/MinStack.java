package com.rishi.leetcode.stack;

import java.util.Stack;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/10/16
 **/
public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.empty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if(!data.empty()) {
            if(data.pop().equals(min.peek())) {
                min.pop();
            }
        }
        throw new RuntimeException("error");
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        if(!data.empty()) {
            return min.peek();
        }
        throw new RuntimeException("");
    }

}

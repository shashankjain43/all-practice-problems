package com.practice.leetcode.ds_design;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        int x = q1.poll();
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return x;
    }

    /** Get the top element. */
    public int top() {
        int x = pop();
        push(x);
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

}

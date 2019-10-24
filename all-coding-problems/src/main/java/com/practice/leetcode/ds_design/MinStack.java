package com.practice.leetcode.ds_design;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack = new LinkedList<>();
        mainStack = new LinkedList<>();
    }

    public void push(int x) {
        mainStack.push(x);
        minStack.push(Math.min(x, minStack.isEmpty() ? x : minStack.peek()));
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.isEmpty() ? 0 : mainStack.peek();
    }

    public int getMin() {

        return minStack.isEmpty() ? 0 : minStack.peek();
    }
}

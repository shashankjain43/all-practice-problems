package com.practice.leetcode.ds_design;

import java.util.Deque;
import java.util.LinkedList;

public class MaxStack {

    Deque<Integer> mainStack;
    Deque<Integer> maxStack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        maxStack = new LinkedList<>();
        mainStack = new LinkedList<>();
    }

    public void push(int x) {
        mainStack.push(x);
        maxStack.push(Math.max(x, maxStack.isEmpty() ? x : maxStack.peek()));
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Deque<Integer> tempStack = new LinkedList<>();
        while (!mainStack.isEmpty() && !maxStack.isEmpty() && mainStack.peek() < maxStack.peek()) {
            tempStack.push(mainStack.pop());
            maxStack.pop();
        }
        int max = mainStack.pop();
        maxStack.pop();
        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
        return max;
    }
}

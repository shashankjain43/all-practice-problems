package com.practice.gfg.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int a) {
        stack.push(a);
        if (min.isEmpty() || min.peek() >= a) {
            min.push(a);
        }
    }

    public int pop() {
        if (min.isEmpty() || stack.isEmpty()) {
            return -1;
        }
        int a = stack.pop();
        if (a <= min.peek()) {
            min.pop();
        }
        return a;
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }

    public static void main(String[] args) {
        NextLargerElement.FastReader fr = new NextLargerElement.FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            MinStack minStack = new MinStack();
            while (size > 0) {
                int c = fr.nextInt();
                if (c == 1) {
                    minStack.push(fr.nextInt());
                } else if (c == 2) {
                    System.out.print(minStack.pop() + " ");
                } else if (c == 3) {
                    System.out.print(minStack.getMin() + " ");
                }
                size--;
            }
            System.out.println();
        }
    }
}
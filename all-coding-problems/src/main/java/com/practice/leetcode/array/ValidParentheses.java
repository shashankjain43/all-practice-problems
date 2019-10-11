package com.practice.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    public boolean isValid(String s) {


        Deque<Character> stack = new LinkedList<>();
        if (s != null && !s.isEmpty()) {
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    if (ch == ')') {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            return false;
                        }
                    } else if (ch == '}') {
                        if (stack.isEmpty() || stack.peek() != '{') {
                            return false;
                        }
                    } else if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

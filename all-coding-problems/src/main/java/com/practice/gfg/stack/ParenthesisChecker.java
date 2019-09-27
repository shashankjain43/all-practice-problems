package com.practice.gfg.stack;

import com.practice.gfg.FastReader;

import java.util.Deque;
import java.util.LinkedList;

public class ParenthesisChecker {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.nextLine();
            System.out.println(!checkParenthesisChecker(str) ? "not balanced" : "balanced");
        }
    }

    private static boolean checkParenthesisChecker(String str) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch == '}' && !stack.isEmpty() && stack.peek() == '{')
                    || (ch == ']' && !stack.isEmpty() && stack.peek() == '[')
                    || (ch == ')' && !stack.isEmpty() && stack.peek() == '(')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}

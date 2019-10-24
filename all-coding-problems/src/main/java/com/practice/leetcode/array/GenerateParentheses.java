package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        generateParenthesisUtil(list, "", 0, 0, n);
        list.stream().forEach(s -> System.out.println(s));

        return new ArrayList<>();

    }

    private void generateParenthesisUtil(List<String> list, String str, int open, int close, int size) {
        if (close == size) {
            list.add(str);
            return;
        }
        if(open < size){
            generateParenthesisUtil(list, str + "{", open + 1, close, size);
        }
        if (open > close) {
            generateParenthesisUtil(list, str + "}", open, close + 1, size);
        }

    }

}

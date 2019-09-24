package com.practice.string;

import com.practice.FastReader;

import java.util.HashMap;
import java.util.Map;

public class FormPalindrome {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.nextLine();
            System.out.println(getInsertionsToFormPalindrome(str));
        }
    }

    private static int getInsertionsToFormPalindrome(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.remove(ch);
            } else {
                map.put(ch, 1);
            }
        }
        return map.size() - 1;
    }

}

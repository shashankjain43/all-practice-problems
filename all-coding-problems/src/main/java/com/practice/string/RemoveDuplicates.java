package com.practice.string;

import com.practice.FastReader;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.nextLine();
            System.out.println(removeDuplicates(str));
        }
    }

    private static String removeDuplicates(String str) {

        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int ptr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                arr[ptr] = arr[i];
                ptr++;
            }
        }
        return String.valueOf(arr, 0, ptr);
    }
}
package com.practice.gfg.string;

import com.practice.gfg.FastReader;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctCharsInString {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.next();
            printLongestDistinctCharsInString(str);
        }
    }

    private static void printLongestDistinctCharsInString(String str) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int maxStart = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                if (map.size() > maxLen) {
                    maxLen = map.size();
                    maxStart = start;
                }
                for (int j = start; j < map.get(ch); j++) {
                    map.remove(str.charAt(j));
                }
                start = map.get(ch) + 1;
                map.remove(ch);
            } else if(i == str.length()-1){
                if (map.size() + 1 > maxLen) {
                    maxLen = map.size() + 1;
                    maxStart = start;
                }
            }
            map.put(ch, i);
        }
        System.out.println(str.substring(maxStart, maxStart + maxLen));
    }
}
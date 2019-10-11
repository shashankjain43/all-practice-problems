package com.practice.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

    public String minWindow(String str, String pat) {

        if (pat.length() > str.length()) {
            return "";
        }
        Map<Character, Integer> strMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            strMap.put(ch, 0);
        }
        Map<Character, Integer> patMap = pat.chars()
                .boxed()
                .collect(Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        int startResult = -1;
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            strMap.put(currChar, strMap.get(currChar) + 1);
            if (patMap.containsKey(currChar) && strMap.get(currChar) <= patMap.get(currChar)) {
                count++;
            }
            //Window found
            if (count == pat.length()) {
                //remove extra chars from begin of this current window
                while (!patMap.containsKey(str.charAt(start)) || strMap.get(str.charAt(start)) > patMap.get(str.charAt(start))) {
                    if (patMap.containsKey(str.charAt(start)) && strMap.get(str.charAt(start)) > patMap.get(str.charAt(start))) {
                        strMap.put(str.charAt(start), strMap.get(str.charAt(start)) - 1);
                    }
                    start++;
                }
                if (minLen > i - start + 1) {
                    minLen = i - start + 1;
                    startResult = start;
                }
            }
        }
        if (startResult == -1) {
            return "";
        }
        return str.substring(startResult, startResult + minLen);

    }

}

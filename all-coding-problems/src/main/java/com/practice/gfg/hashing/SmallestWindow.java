package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SmallestWindow {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String arr = fr.nextLine();
            String pat = fr.nextLine();
            System.out.println(printSmallestWindow1(arr, pat));
        }
    }

    private static String printSmallestWindow1(String str, String pat) {

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


    private static void printSmallestWindow(String str, String pat) {

        if (pat.length() > str.length()) {
            System.out.println(-1);
            return;
        }
        Map<Character, Integer> strMap = new HashMap<>();
                /*str.chars()
                .boxed()
                .collect(Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));*/

        Map<Character, Integer> patMap = pat.chars()
                .boxed()
                .collect(Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (strMap.containsKey(str.charAt(i))) {
                strMap.put(str.charAt(i), strMap.get(str.charAt(i)) + 1);
            } else {
                strMap.put(str.charAt(i), 1);
            }
            if (patMap.containsKey(str.charAt(i)) && strMap.get(str.charAt(i)) <= patMap.get(str.charAt(i))) {
                count++;
            }
            //Window found
            if (count == pat.length()) {
                //remove extra chars from begin of this current window
                char currChar = str.charAt(start);
                while (!patMap.containsKey(currChar) || strMap.get(currChar) > patMap.get(currChar)) {

                    if (patMap.containsKey(currChar) && strMap.get(currChar) > patMap.get(currChar)) {
                        if (strMap.get(currChar) > 1) {
                            strMap.put(currChar, strMap.get(currChar) - 1);
                        } else {
                            strMap.remove(currChar);
                        }

                    }
                    start++;
                }
                minLen = Math.min(minLen, i - start + 1);
            }
        }


    }



}
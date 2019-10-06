package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Map;
import java.util.stream.Collectors;

public class SmallestWindow {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String arr = fr.nextLine();
            String pat = fr.nextLine();
            printSmallestWindow(arr, pat);
        }
    }

    private static void printSmallestWindow(String str, String pat) {

        if (pat.length() > str.length()) {
            System.out.println(-1);
            return;
        }
        Map<Character, Integer> strMap = str.chars()
                .boxed()
                .collect(Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        Map<Character, Integer> patMap = pat.chars()
                .boxed()
                .collect(Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (patMap.containsKey(str.charAt(i)) && strMap.get(str.charAt(start)) > patMap.get(str.charAt(start))) {
                count++;
            }
            if (count == pat.length()) {
                //remove extra chars from begining
                while (!patMap.containsKey(str.charAt(start)) || strMap.get(str.charAt(start)) > patMap.get(str.charAt(start))) {
                    start++;
                }
                minLen = Math.min(minLen, i - start + 1);
            }
        }
    }
}
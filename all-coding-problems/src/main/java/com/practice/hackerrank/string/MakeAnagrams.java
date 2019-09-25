package com.practice.hackerrank.string;

import com.practice.gfg.FastReader;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagrams {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str1 = fr.next();
            String str2 = fr.next();
            System.out.println(makeAnagram(str1, str2));
        }
    }

    static int makeAnagram(String a, String b) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int  count = 0;
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                count++;
            }
        }

        return count + map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
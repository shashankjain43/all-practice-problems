package com.practice.gfg.string;

import com.practice.gfg.FastReader;
import sun.nio.cs.CharsetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str1 = fr.next();
            String str2 = fr.next();
            System.out.println(!anagram(str1, str2) ? "NO" : "YES");
        }
    }

    public static boolean anagram(String str1, String str2) {

        Map<Character, Integer> map1 = str1.chars().boxed().collect(Collectors.groupingBy(o -> Character.valueOf((char) o.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        Map<Character, Integer> map2 = str2.chars().boxed().collect(Collectors.groupingBy(o -> Character.valueOf((char) o.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        if (map1.size() == map2.size()) {
            for (Map.Entry<Character, Integer> e : map1.entrySet()) {
                if (e.getValue() != map2.get(e.getKey())) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        for (int i = 0; i < sl; i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (char c : smap.keySet()) {
            if (smap.get(c) != 0) {
                return false;
            }
        }

        return true;
    }

    static boolean areAnagram(String str1, String str2) {

        str1 = str1.replaceAll("\\p{Punct}", "");
        str1 = str1.replaceAll("\\s", "");
        str1 = str1.toLowerCase();

        str2 = str2.replaceAll("\\p{Punct}", "");
        str2 = str2.replaceAll("\\s", "");
        str2 = str2.toLowerCase();
        int count1[] = new int[256];
        Arrays.fill(count1, 0);
        int count2[] = new int[256];
        Arrays.fill(count2, 0);
        int i;

        for (i = 0; i < str1.length() && i < str2.length();
             i++) {
            count1[str1.charAt(i)]++;
            count2[str2.charAt(i)]++;
        }

        if (str1.length() != str2.length())
            return false;

        // Compare count arrays
        for (i = 0; i < 256; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }

}

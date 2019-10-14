package com.practice.leetcode.array;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('|');
                sb.append(i);
            }
            List<String> orDefault = map.getOrDefault(sb.toString(), new LinkedList<String>());
            orDefault.add(str);
            map.put(sb.toString(), orDefault);
        }

        return new ArrayList<>(map.values());

    }
}

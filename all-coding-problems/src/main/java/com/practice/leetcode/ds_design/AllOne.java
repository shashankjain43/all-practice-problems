package com.practice.leetcode.ds_design;

import java.util.*;

public class AllOne {

    Map<String, Integer> map;
    Queue<Pair> minHeap;
    Queue<Pair> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
        minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
        Pair p = new Pair(key, map.get(key));
        minHeap.remove(p);
        minHeap.offer(p);
        maxHeap.remove(p);
        maxHeap.offer(p);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if(map.containsKey(key)){
            map.put(key, map.get(key) - 1);
        } else {
            return;
        }
        Pair p = new Pair(key, map.get(key));
        if (map.get(key) <= 0) {
            map.remove(key);
            minHeap.remove(p);
            maxHeap.remove(p);
        } else {
            minHeap.remove(p);
            minHeap.offer(p);
            maxHeap.remove(p);
            maxHeap.offer(p);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return maxHeap.isEmpty() ? "" : maxHeap.peek().str;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return minHeap.isEmpty() ? "" : minHeap.peek().str;
    }

    class Pair {
        String str;
        int val;

        Pair(String s, int i) {
            str = s;
            val = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(str, pair.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
    }
}

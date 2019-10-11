package com.practice.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map ;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };

    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        System.out.println("cache.put(1, 1)   "+cache.toString());
        cache.put(2, 2);
        System.out.println("cache.put(2, 2)   "+cache.toString());
        cache.get(1);       // returns 1
        System.out.println("cache.get(1)      "+cache.toString());
        cache.put(3, 3);    // evicts key 2
        System.out.println("cache.put(3, 3)   "+cache.toString());
        cache.get(2);       // returns -1 (not found)
        System.out.println("cache.get(2)      "+cache.toString());
        cache.put(4, 4);    // evicts key 1
        System.out.println("cache.put(4, 4)   "+cache.toString());
        cache.get(1);       // returns -1 (not found)
        System.out.println("cache.get(1)      "+cache.toString());
        cache.get(3);       // returns 3
        System.out.println("cache.get(3)      "+cache.toString());
        cache.get(4);       // returns 4
        System.out.println("cache.get(4)      "+cache.toString());
    }

}

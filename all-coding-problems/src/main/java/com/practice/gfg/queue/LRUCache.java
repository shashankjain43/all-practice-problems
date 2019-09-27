package com.practice.gfg.queue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LRUCache(int N) {
        super(N, 0.75f, true);
        capacity = N;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int x) {
        if (containsKey(x)) {
            return super.get(x);
        }
        return -1;
    }

    public void set(int x, int y) {
        put(x, y);
    }
}

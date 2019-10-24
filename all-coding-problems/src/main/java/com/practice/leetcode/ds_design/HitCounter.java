package com.practice.leetcode.ds_design;

import java.util.PriorityQueue;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> pq;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        this.pq = new PriorityQueue<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        this.pq.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!pq.isEmpty() && pq.peek() <= timestamp - 300) {
            pq.poll();
        }
        return pq.size();
    }
}

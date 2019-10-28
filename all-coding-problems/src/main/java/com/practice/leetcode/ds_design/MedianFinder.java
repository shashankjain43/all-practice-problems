package com.practice.leetcode.ds_design;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> minHeapRight ;
    Queue<Integer> maxHeapLeft;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeapRight = new PriorityQueue<>(Comparator.naturalOrder());
        maxHeapLeft = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {

        if (minHeapRight.isEmpty() && maxHeapLeft.isEmpty()) {
            maxHeapLeft.offer(num);
        } else {
            if (num > maxHeapLeft.peek()) {
                minHeapRight.offer(num);
            } else {
                maxHeapLeft.offer(num);
            }

            if (minHeapRight.size() > maxHeapLeft.size()) {
                maxHeapLeft.offer(minHeapRight.poll());
            } else {
                if (minHeapRight.size() == maxHeapLeft.size() - 2)
                    minHeapRight.offer(maxHeapLeft.poll());
            }
        }
    }

    public double findMedian() {
        if ((maxHeapLeft.size() + minHeapRight.size()) % 2 == 0) {
            return (minHeapRight.peek() + maxHeapLeft.peek()) / 2.0;
        } else {
            return maxHeapLeft.peek();
        }
    }
}

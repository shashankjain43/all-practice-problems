package com.practice.leetcode.ds_design;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> queue;
    int capacity;
    double runningSum;

    public MovingAverage(int size) {

        this.capacity = size;
        this.queue = new LinkedList<Integer>();
        this.runningSum = 0;
    }

    public double next(int val) {

        if(queue.size() >= capacity){
            runningSum = runningSum - queue.peek();
            queue.poll();
        }
        queue.offer(val);
        runningSum = runningSum + val;
        return runningSum/queue.size();
    }
}

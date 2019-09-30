package com.practice.gfg.heap;

import com.practice.gfg.FastReader;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianInStream {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int size = fr.nextInt();
        int arr[] = new int[size];
        for (int j = 0; j < size; j++) {
            arr[j] = fr.nextInt();
        }
        printMedianInStream(arr);
    }

    private static void printMedianInStream(int[] arr) {
        Queue<Integer> minHeapRight = new PriorityQueue<>(Comparator.naturalOrder());
        Queue<Integer> maxHeapLeft = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
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
            if ((maxHeapLeft.size() + minHeapRight.size()) % 2 == 0) {
                System.out.println((minHeapRight.peek() + maxHeapLeft.peek()) / 2);
            } else {
                System.out.println(maxHeapLeft.peek());
            }
        }
    }

}

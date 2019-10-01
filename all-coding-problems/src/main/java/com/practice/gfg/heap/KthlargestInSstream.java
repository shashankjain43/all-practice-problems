package com.practice.gfg.heap;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class KthlargestInSstream {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int k = fr.nextInt();
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            printKthlargestInStream(arr, k);
            System.out.println();
        }
    }

    private static void printKthlargestInStream(int[] arr, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(arr).limit(k).forEach(value -> minHeap.add(value));
        IntStream.range(1, k).forEach(value -> System.out.print(-1 + " "));
        for (int i = k; i < arr.length; i++) {
            System.out.print(minHeap.peek() + " ");
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        System.out.print(minHeap.peek() + " ");
    }
}

package com.practice.array;

import com.practice.FastReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            int k = fr.nextInt();
            System.out.println(getKthSmallestElement(arr, k));
        }
    }

    private static int getKthSmallestElement(int[] arr, int k) {

        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        Arrays.stream(arr).limit(k).forEach(maxHeap::add);
        for (int i = k; i < arr.length; i++) {
            if(maxHeap.peek() > arr[i]){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }
}
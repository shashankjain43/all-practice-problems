package com.practice.gfg.queue;

import com.practice.gfg.FastReader;

import java.util.*;

public class MaximumOfAllSubarraysOfSizeK {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int k = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            slidingWindowMaximum(arr, k);
            System.out.println();
        }
    }

    private static void slidingWindowMaximum(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            System.out.print(dq.peek() + " ");
            if (!dq.isEmpty() && dq.peek() == arr[i - k]) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[i] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(arr[i]);
        }
        System.out.print(dq.peek());
    }
}
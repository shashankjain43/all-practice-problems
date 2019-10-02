package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            findLargestSubarrayWithZeroSum(arr);
        }
    }

    private static void findLargestSubarrayWithZeroSum(int[] arr) {

        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (map.containsKey(sum)) {
                //printArray(arr, map.get(sum) + 1 , i);
                maxLen = Math.max(i - map.get(sum), maxLen);
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(maxLen);
    }

    private static void printArray(int[] arr, int i, int i1) {
        for (int j = i; j < i1; j++) {
            System.out.print(arr[j] + " ");
        }
    }

}

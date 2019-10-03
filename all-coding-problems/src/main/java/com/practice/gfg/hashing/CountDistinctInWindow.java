package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.Map;

public class CountDistinctInWindow {

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
            countDistinct(arr, k, size);
            System.out.println();
        }
    }

    static void countDistinct(int arr[], int k, int n) {

        Map<Integer, Integer> map = Arrays.stream(arr)
                .limit(k)
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(java.util.function.Function.identity(),
                        java.util.stream.Collectors.collectingAndThen(java.util.stream.Collectors.counting(),
                                Long::intValue)));

        System.out.print(map.size() + " ");
        for (int i = k; i < n; i++) {
            //remove entry outside the window
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            //add new element in window
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            System.out.print(map.size() + " ");
        }
    }
}

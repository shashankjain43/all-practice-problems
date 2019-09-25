package com.practice.gfg.array;

import com.practice.gfg.FastReader;

import java.util.Arrays;

public class LargestNumberFormedFromArray {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(getLargestNumberFormedFromArray(arr));
        }
    }

    private static String getLargestNumberFormedFromArray(int[] arr) {
        return Arrays.stream(arr).boxed().map(String::valueOf).sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).reduce((s1, s2) -> s1 + s2).get();
    }
}

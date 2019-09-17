package com.practice.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumberInArray {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt() - 1;
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(findMissingNumberInArray(arr));
        }
    }

    private static int findMissingNumberInArray(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int nSum = IntStream.range(1, arr.length + 2).sum();
        return nSum - sum;
    }
}
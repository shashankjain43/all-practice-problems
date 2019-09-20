package com.practice.array;

import java.util.Arrays;

public class ChoclateDistribution {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            int students = fr.nextInt();
            findMinimumDifference(arr, students);
        }
    }

    private static void findMinimumDifference(int[] arr, int students) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = students - 1; i < arr.length; i++) {
            if (arr[i] - arr[i - students + 1] < minDiff) {
                minDiff = arr[i] - arr[i - students + 1];
            }
        }
        System.out.println(minDiff);
    }
}

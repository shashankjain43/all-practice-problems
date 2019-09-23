package com.practice.array;

import java.util.Arrays;

public class TwoNumbersWithSumClosestToZero {
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(getSumClosestToZero(arr));
        }
    }

    private static int getSumClosestToZero(int[] arr) {

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        while (left < right) {
            if (Math.abs(arr[left] + arr[right]) < Math.abs(minSum)) {
                minSum = arr[left] + arr[right];
            }
            if (arr[left] + arr[right] < 0) {
                left++;
            } else if (arr[left] + arr[right] > 0) {
                right--;
            } else {
                minSum = 0;
                break;
            }
        }
        return minSum;
    }
}

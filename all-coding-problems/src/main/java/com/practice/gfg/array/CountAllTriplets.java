package com.practice.gfg.array;

import com.practice.gfg.FastReader;

import java.util.Arrays;

public class CountAllTriplets {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(countAllTriplets(arr));
        }
    }

    private static int countAllTriplets(int[] arr) {
        int triplets = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] == arr[i]) {
                    triplets++;
                    left++;
                    right--;
                } else if (arr[left] + arr[right] < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        if (triplets == 0) {
            return -1;
        }
        return triplets;
    }
}

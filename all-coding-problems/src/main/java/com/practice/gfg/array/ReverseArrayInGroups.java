package com.practice.gfg.array;

import com.practice.gfg.FastReader;

import java.util.Arrays;

public class ReverseArrayInGroups {
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
            reverseArrayInGroups(arr, k);
            Arrays.stream(arr).forEach((e) -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void reverseArrayInGroups(int[] arr, int k) {
        for (int i = 0; i < arr.length; i = i + k) {
            reverse(arr, i, arr.length - i < k ? arr.length - 1 : i + k - 1);
        }
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(i, j, arr);
            i++;
            j--;
        }
    }

    static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
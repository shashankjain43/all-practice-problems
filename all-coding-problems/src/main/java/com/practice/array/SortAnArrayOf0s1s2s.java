package com.practice.array;

import com.practice.FastReader;

import java.util.Arrays;

public class SortAnArrayOf0s1s2s {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            sortAnArrayOf0s1s2s(arr);
            Arrays.stream(arr).forEach((num) -> System.out.print(num + " "));
            System.out.println();
        }
    }

    private static void sortAnArrayOf0s1s2s(int[] arr) {
        int zero = 0;
        int one = 0;
        int two = arr.length - 1;
        while (one <= two) {
            switch (arr[one]) {
                case 0:
                    swap(zero, one, arr);
                    zero++;
                    one++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    swap(one, two, arr);
                    two--;
                    break;
            }
        }
    }

    static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

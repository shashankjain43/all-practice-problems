package com.practice.array;

import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            printPythagoreanTriplet(arr);
        }
    }

    private static void printPythagoreanTriplet(int[] arr) {
        arr = Arrays.stream(arr).map(e -> e * e).sorted().toArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (arr[j] + arr[k] == arr[i]) {
                    System.out.println("Yes");
                    return;
                }
                if (arr[j] + arr[k] < arr[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println("No");
    }
}

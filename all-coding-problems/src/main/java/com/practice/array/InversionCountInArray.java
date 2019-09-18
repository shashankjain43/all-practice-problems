package com.practice.array;

import java.util.Arrays;

public class InversionCountInArray {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(getInversionCountInArray(arr));
        }
    }

    private static int getInversionCountInArray(int[] arr) {
        int result = 0;



        return result;
    }
}

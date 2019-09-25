package com.practice.gfg.array;

import com.practice.gfg.FastReader;

import java.util.Arrays;

public class EquilibriumPoint {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(getEquilibriumPoint(arr));
        }
    }

    private static int getEquilibriumPoint(int[] arr) {
        int eqIndex = -1;
        int rSum = Arrays.stream(arr).sum();
        int lSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rSum = rSum - arr[i];
            if (rSum == lSum) {
                eqIndex = i + 1;
                break;
            }
            lSum = lSum + arr[i];
        }
        return eqIndex > -1 ? eqIndex : -1;
    }
}

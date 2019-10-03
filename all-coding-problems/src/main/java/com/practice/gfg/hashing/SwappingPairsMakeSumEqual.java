package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;

public class SwappingPairsMakeSumEqual {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size1 = fr.nextInt();
            int size2 = fr.nextInt();
            int arr1[] = new int[size1];
            for (int j = 0; j < size1; j++) {
                arr1[j] = fr.nextInt();
            }
            int arr2[] = new int[size2];
            for (int j = 0; j < size2; j++) {
                arr2[j] = fr.nextInt();
            }
            System.out.println(!findIfSwappingPairsMakeSumEqual(arr1, arr2) ? -1 : 1);
        }
    }

    private static boolean findIfSwappingPairsMakeSumEqual(int[] arr1, int[] arr2) {

        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();

        int diffSum = Math.abs(sum1 - sum2);

        if (sum2 > sum1) {
            for (int i = 0; i < arr1.length; i++) {
                if (ifExists(arr2, arr1[i] + diffSum / 2)) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < arr2.length; i++) {
                if (ifExists(arr1, arr2[i] + diffSum / 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean ifExists(int[] arr2, int i) {

        for (int j = 0; j < arr2.length; j++) {
            if (arr2[j] == i) {
                return true;
            }
        }
        return false;
    }
}

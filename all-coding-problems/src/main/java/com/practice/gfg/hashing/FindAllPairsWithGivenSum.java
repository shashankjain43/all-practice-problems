package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindAllPairsWithGivenSum {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size1 = fr.nextInt();
            int size2 = fr.nextInt();
            int sum = fr.nextInt();
            int arr1[] = new int[size1];
            int arr2[] = new int[size2];
            for (int j = 0; j < size1; j++) {
                arr1[j] = fr.nextInt();
            }
            for (int j = 0; j < size2; j++) {
                arr2[j] = fr.nextInt();
            }
            printAllPairsWithGivenSum(arr1, arr2, sum);
        }
    }

    private static void printAllPairsWithGivenSum(int[] arr1, int[] arr2, int sum) {

        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr2).boxed().forEach(set::add);
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(sum - arr1[i])) {
                sf.append(arr1[i] + " " + (sum - arr1[i]) + ", ");
                set.remove(sum - arr1[i]);
            }
        }
        if (sf.length() > 0) {
            System.out.println(sf.toString().substring(0, sf.length() - 2));
        } else {
            System.out.println(-1);
        }
    }
}
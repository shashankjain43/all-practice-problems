package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySubsetOfAnotherArray {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size1 = fr.nextInt();
            int arr1[] = new int[size1];
            int size2 = fr.nextInt();
            int arr2[] = new int[size2];
            for (int j = 0; j < size1; j++) {
                arr1[j] = fr.nextInt();
            }
            for (int j = 0; j < size2; j++) {
                arr2[j] = fr.nextInt();
            }
            System.out.println(!checkArraySubsetOfAnotherArray(arr1, arr2)? "No":"Yes");
        }
    }

    private static boolean checkArraySubsetOfAnotherArray(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr1).boxed().forEach(set::add);

        for(int i: arr2){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}

package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZeroSumSubarrays {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size1 = fr.nextInt();
            int arr1[] = new int[size1];
            for (int j = 0; j < size1; j++) {
                arr1[j] = fr.nextInt();
            }
            System.out.println(countZeroSumSubarrays(arr1));
        }
    }

    private static int countZeroSumSubarrays(int[] arr1) {

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> set = new HashMap<>();
        set.put(0, -1);
        for (int i = 0; i < arr1.length; i++) {
            sum = sum + arr1[i];
            if (set.containsKey(sum)) {
                count++;
                System.out.println("found 0 sum at: " + i+" and value= "+arr1[i]+" and sum= "+sum + " And Set is: "+set);
            } else {
                set.put(sum, i);
            }
        }
        return count;
    }
}

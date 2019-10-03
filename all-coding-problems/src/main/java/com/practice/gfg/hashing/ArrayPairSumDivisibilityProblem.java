package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayPairSumDivisibilityProblem {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            int k = fr.nextInt();
            System.out.println(!checkArrayPairSumDivisibilityProblem(arr, k) ? "False" : "True");
        }
    }

    private static boolean checkArrayPairSumDivisibilityProblem(int[] arr, int k) {

        Map<Integer, Integer> collect = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(integer -> integer % k, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        //collect.forEach((integer, integer2) -> System.out.println(integer +" "+integer2));
        for (int i = 0; i < arr.length; i++) {
            int currRem = arr[i] % k;
            int freqOfCurrRem = collect.get(currRem);
            if(currRem == 0){
                if(freqOfCurrRem % 2 != 0){
                    return false;
                }
            } else if(currRem == k/2){
                if(freqOfCurrRem % 2 != 0){
                    return false;
                }
            } else if(collect.get(k - currRem) == null || freqOfCurrRem != collect.get(k - currRem)){
                return false;
            }
        }
        return true;
    }
}

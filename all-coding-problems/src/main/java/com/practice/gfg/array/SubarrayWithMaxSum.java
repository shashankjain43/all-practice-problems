package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class SubarrayWithMaxSum {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            printSubarrayWithMaxSum(arr);
        }
    }

    private static void printSubarrayWithMaxSum(int[] arr) {

        int globalMax = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if(currSum > globalMax){
                globalMax = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        System.out.println(globalMax);
    }
}

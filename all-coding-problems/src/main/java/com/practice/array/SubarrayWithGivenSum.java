package com.practice.array;

import java.lang.*;

public class SubarrayWithGivenSum {
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int sum = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            subarrayWithGivenSum(arr, sum);
        }
    }

    private static void subarrayWithGivenSum(int[] arr, int sum) {

        int currSum = arr[0];
        int lIndex = 0;
        int rIndex = -1;
        for (int i = 1; i < arr.length; i++) {

            currSum = currSum + arr[i];

            while (currSum > sum) {
                currSum = currSum - arr[lIndex];
                lIndex++;
            }

            if (currSum == sum) {
                rIndex = i;
                break;
            }
        }

        if (rIndex > -1) {
            System.out.println(String.format("%s %s", ++lIndex, ++rIndex));
        } else
            System.out.println("" + -1);


    }
}

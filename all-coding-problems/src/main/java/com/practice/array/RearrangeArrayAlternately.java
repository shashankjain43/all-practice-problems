package com.practice.array;

import java.util.Arrays;

public class RearrangeArrayAlternately {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            rearrangeArrayAlternately(arr);
            Arrays.stream(arr).forEach((num)-> System.out.print(num+" "));
        }
    }

    private static void rearrangeArrayAlternately(int[] arr) {

        // reverse the array to get Descending order
        // reverse later half of array
        // Now for each element in later half array do following
            //
    }

}

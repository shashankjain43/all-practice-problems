package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {

        Integer[] integers = Arrays.stream(A)
                .boxed()
                .sorted((o1, o2) -> {
                    if (o1 % 2 == 0 && o2 % 2 != 0) {
                        return -1;
                    } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                        return 1;
                    }
                    return o1 - o2;
                })
                .collect(Collectors.toList())
                .toArray(new Integer[0]);

        int j = 0;
        for (int i : integers) {
            A[j++] = i;
        }
        return A;
    }

    public int[] sortArrayByParity1(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            //till even on left
            while (left < arr.length && arr[left] % 2 == 0) {
                left++;
            }
            //till odd on right
            while (right >= 0 && arr[right] % 2 != 0) {
                right--;
            }
            if(left<right){
                swap(arr, left, right);
            }
            left++;
            right--;
        }
        return arr;

    }


    private void swap(int[] a, int left, int right) {
        if (left < a.length && right >= 0) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }

    }

    public static void main(String[] args) {
        SortArrayByParity obj = new SortArrayByParity();
        int[] arr = {0, 2};
        obj.sortArrayByParity1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

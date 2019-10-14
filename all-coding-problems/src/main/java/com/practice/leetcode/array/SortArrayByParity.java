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

    public static void main(String[] args) {
        SortArrayByParity obj = new SortArrayByParity();
        int[] arr = {3, 1, 2, 4};
        obj.sortArrayByParity(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

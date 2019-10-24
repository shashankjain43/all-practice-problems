package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberOfPrizes {

    public static int getNumPrizes(List<Integer> marks, int k) {
        Collections.sort(marks, Comparator.reverseOrder());
        int rank = 1;
        int i = 1;
        for (; i < marks.size(); i++) {
            if (marks.get(i) <= 0) {
                if (marks.get(i - 1) > 0) {
                    return i;
                } else {
                    return 0;
                }
            }
            if (marks.get(i - 1) != marks.get(i)) {
                if (rank == k) {
                    return i;
                }
                rank++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {100, 100, 50, 20, 5, 5};
        //System.out.println(getNumPrizes(Arrays.asList(100,100,50,50,20,5,5), 3));
        //System.out.println(getNumPrizes(Arrays.asList(-1, -2, -3), 4));
        System.out.println(getNumPrizes(Arrays.asList(100,100,100,100), 1));
    }
}

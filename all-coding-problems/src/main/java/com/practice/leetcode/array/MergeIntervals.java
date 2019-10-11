package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        int prev = 0;
        int curr = 1;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        while (curr < intervals.length) {
            while (curr < intervals.length && intervals[prev][1] >= intervals[curr][0] && intervals[prev][0] <= intervals[curr][1]) {
                intervals[prev][0] = Math.min(intervals[prev][0], intervals[curr][0]);
                intervals[prev][1] = Math.max(intervals[prev][1], intervals[curr][1]);
                intervals[curr] = null;
                curr++;
            }
            prev = curr;
            curr++;
        }
        List<int[]> collect = Arrays.stream(intervals).filter(Objects::nonNull).collect(Collectors.toList());
        return collect.toArray(new int[0][0]);

    }

    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = obj.merge(intervals);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}

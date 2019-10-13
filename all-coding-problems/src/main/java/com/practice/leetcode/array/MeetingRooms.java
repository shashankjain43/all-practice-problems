package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {

        int roomNeeded = 0;
        Integer[] arr = Arrays.stream(intervals)
                .map(ints -> ints[0])
                .sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
        Integer[] dep = Arrays.stream(intervals)
                .map(ints -> ints[1])
                .sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
        int arrPtr = 0;
        int depPtr = 0;
        while (arrPtr < intervals.length && depPtr < intervals.length) {
            if (arr[arrPtr] < dep[depPtr]) {
                roomNeeded++;
                arrPtr++;
            } else {
                roomNeeded--;
                depPtr++;
            }
            if (roomNeeded > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean canAttendMeetings1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++)
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        return true;
    }

}

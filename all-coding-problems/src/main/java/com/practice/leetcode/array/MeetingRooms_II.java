package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MeetingRooms_II {

    public int minMeetingRooms(int[][] intervals) {
        int currNeed = 0;
        int minRooms = 0;
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
                currNeed++;
                arrPtr++;
                if(minRooms < currNeed){
                    minRooms = currNeed;
                }
            } else {
                currNeed--;
                depPtr++;
            }
        }
        return minRooms;
    }
}
package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        int arrows = 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int slow = 0;
        int fast = 0;
        while (slow < points.length && fast < points.length) {
            while (fast < points.length && points[slow][1] >= points[fast][0]) {
                fast++;
            }
            arrows++;
            slow = fast;
        }
        return arrows;
    }

    public int findMinArrowShots1(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        int arrows = 1;
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int slow = 0;
        for (int i = 0; i < points.length; i++) {
            if(points[slow][1] < points[i][0]){
                arrows++;
                slow = i;
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons obj = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(obj.findMinArrowShots(arr));
    }
}

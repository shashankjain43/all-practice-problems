package com.practice.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        List<DistanceFromOrigin> distList = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            distList.add(new DistanceFromOrigin(points[i][0] * points[i][0] + points[i][1] * points[i][1], i));
        }
        return distList
                .stream()
                .sorted((o1, o2) -> o1.dist - o2.dist)
                .limit(K)
                .map(node -> node.index)
                .map(integer -> points[integer])
                .collect(Collectors.toList())
                .toArray(new int[0][0]);
    }

    class DistanceFromOrigin {
        int dist;
        int index;
        DistanceFromOrigin(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }
    }
}

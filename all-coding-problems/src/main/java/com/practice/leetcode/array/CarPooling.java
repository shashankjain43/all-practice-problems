package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CarPooling {

    class Pick {
        int people;
        int pick;

        Pick(int people, int pick) {
            this.pick = pick;
            this.people = people;
        }
    }

    class Drop {
        int people;
        int drop;

        Drop(int people, int drop) {
            this.drop = drop;
            this.people = people;
        }
    }


    public boolean carPooling(int[][] trips, int capacity) {

        Pick[] picks = Arrays.stream(trips)
                .map(ints -> new Pick(ints[0], ints[1]))
                .sorted((o1, o2) -> o1.pick - o2.pick)
                .collect(Collectors.toList())
                .toArray(new Pick[0]);

        Drop[] drops = Arrays.stream(trips)
                .map(ints -> new Drop(ints[0], ints[2]))
                .sorted((o1, o2) -> o1.drop - o2.drop)
                .collect(Collectors.toList())
                .toArray(new Drop[0]);

        int currCapacity = capacity;
        int pick = 0;
        int drop = 0;
        while (pick < trips.length && drop < trips.length) {
            if (picks[pick].pick < drops[drop].drop) {
                currCapacity = currCapacity - picks[pick].people;
                pick++;
            } else if (picks[pick].pick > drops[drop].drop) {
                currCapacity = currCapacity + drops[drop].people;
                drop++;
            } else {
                currCapacity = currCapacity - picks[pick].people;
                currCapacity = currCapacity + drops[drop].people;
                pick++;
                drop++;
            }
            if (currCapacity < 0) {
                return false;
            }
        }

        return true;
    }
}

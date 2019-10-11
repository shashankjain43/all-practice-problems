package com.practice.hackerrank.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClearWater_Q4 {

    public static int findMissingNumber(List<Integer> array1, List<Integer> array2) {

        Set<Integer> set = new HashSet<>();
        array2.stream().forEach(set::add);
        for (int i: array1) {
            if(!set.contains(i)){
                return i;
            }
        }
        return 0;
    }

}

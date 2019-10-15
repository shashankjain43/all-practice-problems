package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        arr.stream().mapToInt(Integer::intValue).sum();
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
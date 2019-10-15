package com.practice.leetcode.array;

import java.util.Arrays;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
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
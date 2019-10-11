package com.practice.leetcode.array;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = curSum + nums[i];
            if(curSum < 0){
                curSum = 0;
            }
            if (curSum > maxSum){
                maxSum = curSum;
            }
        }

        return maxSum;

    }
}

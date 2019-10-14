package com.practice.leetcode.array;

public class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                min = nums[i];
                break;
            }
        }
        return min;
    }

    public int findMin1(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                min = nums[i];
                break;
            }
        }
        return min;
    }
}

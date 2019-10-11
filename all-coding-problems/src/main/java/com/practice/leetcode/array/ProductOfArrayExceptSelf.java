package com.practice.leetcode.array;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i - 1];
        }
        nums[0] = right[1];
        nums[nums.length - 1] = left[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = left[i - 1] * right[i + 1];
        }
        return nums;
    }
}

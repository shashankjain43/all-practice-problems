package com.practice.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> listOfList = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    listOfList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return listOfList.stream().collect(Collectors.toList());
    }
}

package com.practice.leetcode.array;

public class SearchInRotatedSortedArray {

    //nums = [4,5,6,7,0,1,2], target = 0, result = 4
    public int search(int[] nums, int target) {
        int result = -1;

        if (nums.length == 0) {
            return result;
        }
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (target <= nums[pivot] && target >= nums[0]) {
            result = binarySearch(nums, 0, pivot, target);
        } else {
            result = binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
        return result;
    }

    private int binarySearch(int[] arr, int low, int high, int key) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(obj.search(nums, target));
    }
}

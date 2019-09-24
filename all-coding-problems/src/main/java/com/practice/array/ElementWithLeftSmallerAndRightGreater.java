package com.practice.array;

import com.practice.FastReader;

public class ElementWithLeftSmallerAndRightGreater {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(getElementWithLeftSmallerAndRightGreater(arr));
        }
    }

    private static int getElementWithLeftSmallerAndRightGreater(int[] arr) {
        int result = -1;

        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                leftMax[i] = arr[i];
                max = arr[i];
            }
            if (arr[arr.length - i - 1] <= min) {
                rightMin[arr.length - i - 1] = arr[arr.length - i - 1];
                min = arr[arr.length - i - 1];
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (leftMax[i] == rightMin[i] && leftMax[i] == arr[i]) {
                result = arr[i];
                break;
            }
        }
        return result;
    }
}

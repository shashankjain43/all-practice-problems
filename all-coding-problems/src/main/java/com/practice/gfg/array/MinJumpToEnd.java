package com.practice.gfg.array;

public class MinJumpToEnd {

	public static void main(String[] args) {

		// int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int i = 0;
		int step = 0;
		while (i < arr.length - 1) {
			int localMax = arr[i + 1];
			int lmIndex = i + 1;
			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				if (localMax < arr[j]) {
					localMax = arr[j];
					lmIndex = j;
				}
			}
			i = lmIndex;
			step++;
		}

		System.out.println("Step needed= " + step);

	}

}

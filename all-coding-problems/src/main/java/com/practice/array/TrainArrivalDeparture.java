package com.practice.array;

import java.util.Arrays;

public class TrainArrivalDeparture {

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		System.out.println("" + getMaxPlatformNeeded(arr, dep));

	}

	private static int getMaxPlatformNeeded(int[] arr, int[] dep) {

		int max = 0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		int currPlatform = 0;
		int arrPtr = 0;
		int depPtr = 0;
		while (arrPtr < arr.length && depPtr < dep.length) {

			if (arr[arrPtr] < dep[depPtr]) {
				arrPtr++;
				currPlatform++;
				if (currPlatform > max) {
					max = currPlatform;
				}
			} else {
				depPtr++;
				currPlatform--;
			}
		}
		return max;
	}

}

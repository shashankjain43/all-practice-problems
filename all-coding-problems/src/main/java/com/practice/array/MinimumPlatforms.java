package com.practice.array;

import com.practice.FastReader;

import java.util.Arrays;

public class MinimumPlatforms {

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		int test = fr.nextInt();
		for (int i = 0; i < test; i++) {
			int size = fr.nextInt();
			int arr[] = new int[size];
			int dep[] = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = fr.nextInt();
			}
			for (int j = 0; j < size; j++) {
				dep[j] = fr.nextInt();
			}
			System.out.println(getMaxPlatformNeeded(arr, dep));
		}
	}

	private static int getMaxPlatformNeeded(int[] arr, int[] dep) {

		int max = 0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		int currPlatform = 0;
		int arrPtr = 0;
		int depPtr = 0;
		while (arrPtr < arr.length && depPtr < dep.length) {
			if (arr[arrPtr] <= dep[depPtr]) {
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

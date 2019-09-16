package com.practice.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecSubsequence {

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int testCases = fastReader.nextInt();
		for (int test = 0; test < testCases; test++) {
			int num = fastReader.nextInt();
			int arr[] = new int[num];
			for (int j = 0; j < num; j++) {
				arr[j] = fastReader.nextInt();
			}
			System.out.println("" + getLongestConsecSubsequence(arr));
		}
	}

	private static int getLongestConsecSubsequence(int[] arr) {
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int j = 0; j < arr.length; j++) {
			set.add(arr[j]);
		}
		for (int j = 0; j < arr.length; j++) {
			if (!set.contains(arr[j] - 1)) {
				int begin = arr[j];
				while (set.contains(begin)) {
					begin++;
				}
				if (begin - arr[j] > max) {
					max = begin - arr[j];
				}
			}
		}
		return max;
	}

}

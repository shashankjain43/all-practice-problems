package com.practice.array;

import com.practice.FastReader;

public class LCS {

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int testCases = fastReader.nextInt();
		for (int test = 0; test < testCases; test++) {
			String arr1 = fastReader.next();
			String arr2 = fastReader.next();
			System.out.println("Length of Longest common subarray is: " + findLCS(arr1, arr2));

		}

	}

	private static int findLCS(String arr1, String arr2) {

		int[][] table = new int[arr2.length()][arr1.length()];
		int maxLen = 0;
		int start = 0;
		int end = 0;

		for (int i = 0; i < arr1.length(); i++) {
			if (arr1.charAt(i) == arr2.charAt(0)) {
				table[0][i] = 1;
				maxLen = 1;
			} else {
				table[0][i] = 0;
			}
		}
		for (int i = 0; i < arr2.length(); i++) {
			if (arr1.charAt(0) == arr2.charAt(i)) {
				table[i][0] = 1;
				maxLen = 1;
			} else {
				table[i][0] = 0;
			}
		}
		for (int i = 1; i < arr2.length(); i++) {
			for (int j = 1; j < arr1.length(); j++) {
				if (arr1.charAt(j) == arr2.charAt(i)) {
					table[i][j] = 1 + table[i - 1][j - 1];
					if (table[i][j] > maxLen) {
						maxLen = table[i][j];
						start = j - maxLen + 1;
						end = j + 1;
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
		System.out.println("Start is: " + start);
		System.out.println("End is: " + end);
		System.out.println("LCS is: " + arr1.substring(start, end));
		return maxLen;
	}

}

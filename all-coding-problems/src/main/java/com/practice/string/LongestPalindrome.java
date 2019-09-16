package com.practice.string;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		String str = "aaaabbaa";
		System.out.println(getLongestPalindrome(str));
	}

	private static int getLongestPalindrome(String str) {

		int size = str.length();
		boolean[][] table = new boolean[size][size];
		int maxLen = 1;
		int start = 0;
		for (int i = 0; i < size; i++) {
			table[i][i] = true;
		}
		for (int i = 0; i < size - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
			}
		}
		maxLen = 2;
		for (int len = 3; len <= size; len++) {
			for (int i = 0; i <= size - len; i++) {
				int j = i + len - 1;
				if (str.charAt(j) == str.charAt(i) && table[i + 1][j - 1]) {
					table[i][j] = true;
					if (maxLen < len) {
						maxLen = len;
						start = i;
					}
				}
			}
		}
		return maxLen;
	}
}

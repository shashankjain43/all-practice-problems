package com.practice.array;

import com.practice.FastReader;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctSubstring {

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int testCases = fastReader.nextInt();
		for (int test = 0; test < testCases; test++) {
			String arr1 = fastReader.next();
			System.out.println("Length of Longest Distinct Substring is: " + findLongestDistinctSubstring(arr1));

		}
	}

	private static int findLongestDistinctSubstring(String arr1) {
		Set<Character> charSet = new HashSet<Character>();
		int maxLen = 0;
		for (int i = 0; i < arr1.length(); i++) {
			if (charSet.contains(arr1.charAt(i))) {
				maxLen = Integer.max(charSet.size(), maxLen);
				charSet.clear();
			}
			charSet.add(arr1.charAt(i));
		}
		return maxLen;
	}

}

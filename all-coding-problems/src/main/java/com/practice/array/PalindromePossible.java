package com.practice.array;

import java.util.HashMap;
import java.util.Map;

public class PalindromePossible {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		if (ifPalindromePossible(str)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean ifPalindromePossible(String str) {
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		fillCountMap(str, countMap);
		if (str.length() % 2 == 0) {
			return countMap.isEmpty();
		} else {
			return countMap.size() == 1;
		}
	}

	private static void fillCountMap(String str, Map<Character, Integer> countMap) {
		for (int i = 0; i < str.length(); i++) {
			char alpha = str.charAt(i);
			if (countMap.containsKey(alpha)) {
				countMap.remove(alpha);
			} else {
				countMap.put(alpha, 1);
			}
		}
	}
}

package com.practice.array;

import java.util.HashMap;
import java.util.Map;

public class CheckEqualFreq {

	public static void main(String[] args) {

		String str = "";
		System.out.println("If equal frequency can be done: " + checkEqualFreqEligible(str));

	}

	private static String checkEqualFreqEligible(String str) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxCount = 0;
		for (char c : str.toCharArray()) {
			int currCount = map.get(c);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);

			} else {
				map.put(c, 1);
			}

			if (currCount > maxCount) {
				maxCount = currCount;
			}
		}
		boolean possible = false;
		for (char key : map.keySet()) {
			int count = map.get(key);
			if (count == maxCount - 1) {
				if (possible == false) {
					possible = true;
				}

			}

		}
		return (possible == true ? "Yes" : "No");
	}

}

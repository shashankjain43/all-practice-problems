package com.practice.gfg.string;

public class ReverseWords {

	public static void main(String[] args) {
		String str = "I am a good boy!";
		System.out.println(reverseWords(str));

	}

	private static String reverseWords(String str) {
		String[] temp = str.split(" ");
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			result = " " + temp[i] + result;
		}
		return result.trim();
	}
}
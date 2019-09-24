package com.practice.string;

import com.practice.FastReader;

public class Anagrams {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str1 = fr.next();
            String str2 = fr.next();
            System.out.println(!checkIfAnagrams(str1, str2) ? "NO" : "YES");
        }
    }

    private static boolean checkIfAnagrams(String str1, String str2) {
        int value = 0;
        for (int i = 0; i < str1.length(); i++) {
            value = value ^ str1.charAt(i) ^ str2.charAt(i);
        }
        return value == 0;
    }
}

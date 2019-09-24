package com.practice.string;

import com.practice.FastReader;

public class CheckIfStringIsRotatedByTwoPlaces {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str1 = fr.nextLine();
            String str2 = fr.nextLine();
            System.out.println(checkIfStringIsRotatedByTwoPlaces(str1, str2) == true ? 1 : 0);
        }
    }

    private static boolean checkIfStringIsRotatedByTwoPlaces(String str1, String str2) {
        String str3 = str2.substring(0, str2.length() - 2);
        String str4 = str2.substring(str2.length() - 2);

        String str5 = str2.substring(0, 2);
        String str6 = str2.substring(2);
        return (str4 + str3).equals(str1) || (str6 + str5).equals(str1);

    }
}

package com.practice.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClearWater_Q2 {

    public static String merge(String s1, String s2) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s1.length() || i < s2.length(); i++) {

            if (i < s1.length())
                result.append(s1.charAt(i));
            if (i < s2.length())
                result.append(s2.charAt(i));
        }

        return result.toString();
    }

    static String mergeStrings(String a, String b) {

        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();

        int j = 0;
        int i = 0;

        int ptr = 0;

        char[] result = new char[arr.length + brr.length];

        while (i < arr.length && j < brr.length) {
            if (ptr % 2 == 0) {
                result[ptr++] = arr[i++];
            } else {
                result[ptr++] = brr[j++];
            }
        }
        if (i < arr.length) {
            return result.toString() + a.substring(i);
        } else if (j < brr.length) {
            return result.toString() + b.substring(j);
        } else {
            return result.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _a;
        try {
            _a = in.nextLine();
        } catch (Exception e) {
            _a = null;
        }

        String _b;
        try {
            _b = in.nextLine();
        } catch (Exception e) {
            _b = null;
        }

        res = mergeStrings(_a, _b);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}

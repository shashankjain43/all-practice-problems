package com.practice.hackerrank.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Q6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String s = br.readLine().trim();

        String out_ = Palindromic_Subsequence(s);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static String Palindromic_Subsequence(final String s) {
        char[] arr = s.toCharArray();
        char minChar = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minChar){
                minChar = arr[i];
            }
        }
        return minChar+"";
    }

}

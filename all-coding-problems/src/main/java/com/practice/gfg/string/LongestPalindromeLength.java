package com.practice.gfg.string;

import com.practice.gfg.FastReader;

public class LongestPalindromeLength {

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String arr = fr.nextLine();
            System.out.println(getLongestPalindrome(arr));
        }
    }

    private static String getLongestPalindrome(String str) {
        char[] arr = str.toCharArray();
        //this will hold the max length of the Palindrome possible in substr(i, j)
        int[][] mat = new int[arr.length][arr.length];

        // init length of palindrome with length = 1
        for (int i = 0; i < arr.length; i++) {
            mat[i][i] = 1;
        }
        int start=0;
        int end = 0;

        for (int len = 2; len <= arr.length; len++) {
            for (int i = 0; i <= arr.length - len; i++) {
                int j = i + len - 1;
                //two end of substr are equal then
                if (arr[i] == arr[j]) {
                    mat[i][j] = mat[i + 1][j - 1] + 2;
                    start = i;
                } else {
                    mat[i][j] = Math.max(mat[i][j - 1], mat[i + 1][j]);
                }
            }
        }
        int i=1;
        while(i< arr.length && mat[i][arr.length-1] == mat[i-1][arr.length-1]){
            i++;
        }
        print2D(mat);
        return String.valueOf(arr, i-1, mat[0][arr.length-1]);
    }

    private static void print2D(int[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
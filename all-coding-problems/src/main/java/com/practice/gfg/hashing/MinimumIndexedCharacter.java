package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

public class MinimumIndexedCharacter {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String arr = fr.nextLine();
            String pat = fr.nextLine();
            findMinimumIndexedCharacter(arr, pat);
        }
    }

    private static void findMinimumIndexedCharacter(String arr, String pat) {
        for (int i = 0; i < arr.length(); i++) {
            if(pat.contains(arr.charAt(i)+"")){
                System.out.println(arr.charAt(i));
                return;
            }
        }
        System.out.println("$");
    }

}

package com.practice.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SmallestPositiveMissingNumber {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            System.out.println(getSmallestPositiveMissingNumber(arr));
        }
    }

    private static int getSmallestPositiveMissingNumber(int[] arr) {
        int secMax = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (arr[i] > max) {
                    secMax = max;
                    max = arr[i];
                } else if(arr[i] > secMax){
                    secMax = arr[i];
                }
            }
            if(max - secMax > 1){
                return secMax + 1;
            }
        }
        return max + 1;
    }
}

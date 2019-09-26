package com.practice.gfg.string;

import com.practice.gfg.FastReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LongestDistinctCharsInString {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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
            String str = fr.next();
            printLongestDistinctCharsInString(str);
        }
    }

    private static void printLongestDistinctCharsInString(String str) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int maxStart = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                if (map.size() > maxLen) {
                    maxLen = map.size();
                    maxStart = start;
                }
                for (int j = start; j < map.get(ch); j++) {
                    map.remove(str.charAt(j));
                }
                start = map.get(ch) + 1;
                map.remove(ch);
            } else if(i == str.length()-1){
                if (map.size() + 1 > maxLen) {
                    maxLen = map.size() + 1;
                    maxStart = start;
                }
            }
            map.put(ch, i);
        }
        System.out.println(str.substring(maxStart, maxStart + maxLen));
    }
}
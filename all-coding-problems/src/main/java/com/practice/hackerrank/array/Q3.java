package com.practice.hackerrank.array;

import java.io.*;
import java.util.*;

public class Q3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] s = new String[N];
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().trim().split(" ");
            s[i] = ss[0];
            ar[i] = Integer.parseInt(ss[1]);
        }
        solve(N , s, ar);
        wr.close();
        br.close();
    }

    static void solve(int n, String[] s, int[] ar) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String str = s[i];
            if(!map.containsKey(str)){
                map.put(str, ar[i]);
            }
        }
        map.entrySet().stream().forEach(stringIntegerEntry -> {
            System.out.println(stringIntegerEntry.getKey()+" "+stringIntegerEntry.getValue());
        });

    }
}

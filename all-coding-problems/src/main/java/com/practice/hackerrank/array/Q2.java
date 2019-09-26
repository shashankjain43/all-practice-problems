package com.practice.hackerrank.array;

import java.io.*;

public class Q2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] data = new String[N];
        for (int i_data = 0; i_data < N; i_data++) {
            data[i_data] = br.readLine();
        }

        String[] out_ = database_clean(data);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
            wr.println(out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static String[] database_clean(String[] data) {
        String[] out = new String[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            String[] arr = data[i].split(" ");
            out[2 * i] = arr[0];
            out[2 * i + 1] = "Name :" + removeSpecialChar(arr[1]);
        }
        return out;

    }

    private static String removeSpecialChar(String s) {

        return s.replaceAll("[$#&]","");

    }
}

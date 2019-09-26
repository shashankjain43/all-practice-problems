package com.practice.hackerrank.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] inp = br.readLine().split(" ");
        for(int i=0;i<N;i++)
        {
            A[i] = Integer.parseInt(inp[i]);
        }
        int out_ = solve(N, A);
        wr.println(out_);

        wr.close();
        br.close();
    }
    static int solve(int N,int[] A){
        int curr = 0;
        int near = A[0];
        Arrays.sort(A);
        for ( int i=0; i < A.length; i++ ){
            curr = A[i] * A[i];
            if ( curr <= (near * near) )  {
                near = A[i];
            }
        }
        return near;

    }

}

package com.practice.gfg.stack;

import com.practice.gfg.FastReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class NextLargerElement {

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
            int size = fr.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = fr.nextInt();
            }
            printNextLargerElement(arr);
            System.out.println();
        }
    }

    private static void printNextLargerElement(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = arr.length-2; i >= 0 ; i--) {
            if(arr[i] > arr[i+1] && arr[i] < stack.peek()){
                stack.push(stack.peek());
            } else if (arr[i] > arr[i+1] && arr[i] > stack.peek()){
                stack.push(-1);
            } else if(arr[i] < arr[i+1] ){
                stack.push(arr[i+1]);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }

}

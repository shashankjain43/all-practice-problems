package com.practice.leetcode.matrix;

import com.practice.gfg.FastReader;

public class UniquePaths {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        /*int testCases = fr.nextInt();
        for (int i = 0; i < testCases; i++) {
            int rows = fr.nextInt();
            int columns = fr.nextInt();
            int[][] table = new int[rows][columns];
            System.out.println(countPath(table, rows, columns));
        }*/
        System.out.println(uniquePaths(7, 3));

    }

    private static int countPath(int[][] table, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            table[i][0] = 1;
        }
        for (int i = 0; i < columns; i++) {
            table[0][i] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[rows - 1][columns - 1];
    }

    public static int uniquePaths(int rows, int columns) {
        if (rows == 0 || columns == 0) {
            return 0;
        }
        if (rows == 1 || columns == 1) {
            return 1;
        }
        return uniquePaths(rows, columns - 1) + uniquePaths(rows - 1, columns);
    }

    public static int uniquePaths1(int rows, int columns) {
        int[][] table = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            table[i][0] = 1;
        }
        for (int i = 0; i < columns; i++) {
            table[0][i] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[rows - 1][columns - 1];
    }

}

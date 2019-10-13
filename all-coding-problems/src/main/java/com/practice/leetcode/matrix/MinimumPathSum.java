package com.practice.leetcode.matrix;

public class MinimumPathSum {

    public int minPathSum(int[][] table) {
        int rows = table.length;
        int columns = table[0].length;
        for (int i = 1; i < rows; i++) {
            table[i][0] = table[i - 1][0] + table[i][0];
        }
        for (int i = 1; i < columns; i++) {
            table[0][i] = table[0][i] + table[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                table[i][j] = table[i][j] + Math.min(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[rows - 1][columns - 1];
    }
}
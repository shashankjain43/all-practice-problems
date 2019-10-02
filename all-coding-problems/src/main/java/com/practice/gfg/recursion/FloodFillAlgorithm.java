package com.practice.gfg.recursion;

import com.practice.gfg.FastReader;

public class FloodFillAlgorithm {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases = fr.nextInt();
        for (int i = 0; i < testCases; i++) {
            int rows = fr.nextInt();
            int columns = fr.nextInt();
            int[][] table = new int[rows][columns];
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    table[j][k] = fr.nextInt();
                }
            }
            int row = fr.nextInt();
            int column = fr.nextInt();
            int color = fr.nextInt();
            floodFill(table, rows, columns, row, column, color);
            printTable(table, rows, columns);
            System.out.println();
        }
    }

    private static void printTable(int[][] table, int rows, int columns) {
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                System.out.print(table[j][k] + " ");
            }
        }
    }

    private static void floodFill(int[][] table, int rows, int columns, int row, int column, int color) {

        int sourceColor = table[row][column];
        floodFillUtil(table, rows, columns, row, column, color, sourceColor);
    }

    private static void floodFillUtil(int[][] table, int rows, int columns, int row, int column, int color, int sourceColor) {

        table[row][column] = color;
        //right
        if (isValid(table, row, column + 1, sourceColor, rows, columns)) {
            floodFillUtil(table, rows, columns, row, column + 1, color, sourceColor);
        }
        //down
        if (isValid(table, row + 1, column, sourceColor, rows, columns)) {
            floodFillUtil(table, rows, columns, row + 1, column, color, sourceColor);
        }
        //left
        if (isValid(table, row, column - 1, sourceColor, rows, columns)) {
            floodFillUtil(table, rows, columns, row, column - 1, color, sourceColor);
        }
        //up
        if (isValid(table, row - 1, column, sourceColor, rows, columns)) {
            floodFillUtil(table, rows, columns, row - 1, column, color, sourceColor);
        }
    }

    private static boolean isValid(int[][] table, int row, int column, int sourceColor, int rows, int columns) {
        return row >= 0 && row < rows && column >= 0 && column < columns && table[row][column] == sourceColor;
    }


}

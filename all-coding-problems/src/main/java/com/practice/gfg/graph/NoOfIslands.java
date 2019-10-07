package com.practice.gfg.graph;

import com.practice.gfg.FastReader;

import java.util.ArrayList;

public class NoOfIslands {

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
            System.out.println(getNoOfIslands(table, rows, columns));
        }
    }

    private static int getNoOfIslands(int[][] table, int rows, int columns) {
        int islands = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                if (table[j][k] == 1 && !visited[j][k]) {
                    floodFillUtil(table, rows, columns, j, k, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void floodFillUtil(int[][] table, int rows, int columns, int row, int column, boolean[][] visited) {

        visited[row][column] = true;
        //right
        if (isValid(table, row, column + 1, rows, columns) && !visited[row][column + 1]) {
            floodFillUtil(table, rows, columns, row, column + 1, visited);
        }
        //right-down diagonal
        if (isValid(table, row + 1, column + 1, rows, columns) && !visited[row + 1][column + 1]) {
            floodFillUtil(table, rows, columns, row + 1, column + 1, visited);
        }
        //down
        if (isValid(table, row + 1, column, rows, columns) && !visited[row + 1][column]) {
            floodFillUtil(table, rows, columns, row + 1, column, visited);
        }
        //left-down diagonal
        if (isValid(table, row + 1, column - 1, rows, columns) && !visited[row + 1][column - 1]) {
            floodFillUtil(table, rows, columns, row + 1, column - 1, visited);
        }
        //left
        if (isValid(table, row, column - 1, rows, columns) && !visited[row][column - 1]) {
            floodFillUtil(table, rows, columns, row, column - 1, visited);
        }
        //left-up diagonal
        if (isValid(table, row - 1, column - 1, rows, columns) && !visited[row - 1][column - 1]) {
            floodFillUtil(table, rows, columns, row - 1, column - 1, visited);
        }
        //up
        if (isValid(table, row - 1, column, rows, columns) && !visited[row - 1][column]) {
            floodFillUtil(table, rows, columns, row - 1, column, visited);
        }
        //right-up diagonal
        if (isValid(table, row - 1, column + 1, rows, columns) && !visited[row - 1][column + 1]) {
            floodFillUtil(table, rows, columns, row - 1, column + 1, visited);
        }
    }

    private static boolean isValid(int[][] table, int row, int column, int rows, int columns) {
        return row >= 0 && row < rows && column >= 0 && column < columns && table[row][column] == 1;
    }

    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
        int islands = 0;
        boolean[][] visited = new boolean[N][M];
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (list.get(j).get(k) == 1 && !visited[j][k]) {
                    floodFillUtil(list, N, M, j, k, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void floodFillUtil(ArrayList<ArrayList<Integer>> list, int rows, int columns, int row, int column, boolean[][] visited) {

        visited[row][column] = true;
        //right
        if (isValid(list, row, column + 1, rows, columns) && !visited[row][column + 1]) {
            floodFillUtil(list, rows, columns, row, column + 1, visited);
        }
        //right-down diagonal
        if (isValid(list, row + 1, column + 1, rows, columns) && !visited[row + 1][column + 1]) {
            floodFillUtil(list, rows, columns, row + 1, column + 1, visited);
        }
        //down
        if (isValid(list, row + 1, column, rows, columns) && !visited[row + 1][column]) {
            floodFillUtil(list, rows, columns, row + 1, column, visited);
        }
        //left-down diagonal
        if (isValid(list, row + 1, column - 1, rows, columns) && !visited[row + 1][column - 1]) {
            floodFillUtil(list, rows, columns, row + 1, column - 1, visited);
        }
        //left
        if (isValid(list, row, column - 1, rows, columns) && !visited[row][column - 1]) {
            floodFillUtil(list, rows, columns, row, column - 1, visited);
        }
        //left-up diagonal
        if (isValid(list, row - 1, column - 1, rows, columns) && !visited[row - 1][column - 1]) {
            floodFillUtil(list, rows, columns, row - 1, column - 1, visited);
        }
        //up
        if (isValid(list, row - 1, column, rows, columns) && !visited[row - 1][column]) {
            floodFillUtil(list, rows, columns, row - 1, column, visited);
        }
        //right-up diagonal
        if (isValid(list, row - 1, column + 1, rows, columns) && !visited[row - 1][column + 1]) {
            floodFillUtil(list, rows, columns, row - 1, column + 1, visited);
        }
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> list, int row, int column, int rows, int columns) {
        return row >= 0 && row < rows && column >= 0 && column < columns && list.get(row).get(column) == 1;
    }


}

package com.practice.leetcode.array;

public class Islands {

    public int numIslands(char[][] arr) {
        int islands = 0;
        int row = arr.length;
        if (row <= 0) {
            return 0;
        }
        int column = arr[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] == '1' && !visited[i][j]) {
                    markAllReachableCells(arr, visited, row, column, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void markAllReachableCells(char[][] arr, boolean[][] visited, int row, int column, int currRow,
                                              int currColumn) {
        visited[currRow][currColumn] = true;
        // right
        if (isValidPos(row, column, currRow, currColumn + 1) && arr[currRow][currColumn + 1] == '1'
                && !visited[currRow][currColumn + 1]) {
            markAllReachableCells(arr, visited, row, column, currRow, currColumn + 1);
        }
        // down
        if (isValidPos(row, column, currRow + 1, currColumn) && arr[currRow + 1][currColumn] == '1'
                && !visited[currRow + 1][currColumn]) {
            markAllReachableCells(arr, visited, row, column, currRow + 1, currColumn);
        }
        //left
        if (isValidPos(row, column, currRow, currColumn - 1) && arr[currRow][currColumn - 1] == '1'
                && !visited[currRow][currColumn - 1]) {
            markAllReachableCells(arr, visited, row, column, currRow, currColumn - 1);
        }
        // up
        if (isValidPos(row, column, currRow - 1, currColumn) && arr[currRow - 1][currColumn] == '1'
                && !visited[currRow - 1][currColumn]) {
            markAllReachableCells(arr, visited, row, column, currRow - 1, currColumn);
        }
    }

    private static boolean isValidPos(int row, int column, int currRow, int currColumn) {
        return currRow >= 0 && currRow < row && currColumn >= 0 && currColumn < column;
    }

}

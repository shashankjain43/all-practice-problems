package com.practice.leetcode.array;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        int[] row = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] col = {1, 0, -1, -1, -1, 0, 1, 1};
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    if (isValidPos(rows, columns, i + row[k], j + col[k])) {
                        if (board[i + row[k]][j + col[k]] == 1 || board[i + row[k]][j + col[k]] == 3) {
                            live++;
                        }
                    }
                }
                if(board[i][j] == 1 && (live < 2 || live > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && live == 2){
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    private boolean isValidPos(int rows, int columns, int currRow, int currColumn) {
        return currRow >= 0 && currRow < rows && currColumn >= 0 && currColumn < columns;
    }
}

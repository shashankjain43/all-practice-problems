package com.practice.leetcode.matrix;

public class SetMatrixZeroes {

    public void setZeroes(int[][] board) {

        int rows = board.length;
        int columns = board[0].length;
        boolean isCol_0 = false;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 0) {
                isCol_0 = true;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (board[i][j] == 0) {
                    board[i][0] = 0;
                    board[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (board[i][0] == 0 || board[0][j] == 0) {
                    board[i][j] = 0;
                }
            }
        }

        //make first row zeroes
        if (board[0][0] == 0) {
            for (int i = 0; i < columns; i++) {
                board[0][i] = 0;
            }
        }
        //make first column zeroes
        if(isCol_0){
            for (int i = 0; i < rows; i++) {
                board[i][0] = 0;
            }
        }
    }

    private void makeZero(int[][] board, int i, int j) {
        for (int k = 0; k < board[i].length; k++) {
            if (board[i][k] > 0) {
                board[i][k] = Integer.MIN_VALUE;
            }
        }
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] > 0) {
                board[k][j] = Integer.MIN_VALUE;
            }
        }
    }
}

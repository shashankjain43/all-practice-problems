package com.practice.leetcode.ds_design;

public class TicTacToe {

    int[][] board;
    int winner;
    int[] rowsSum;
    int[] colSum;
    int[] diagSum;
    int size;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new int[n][n];
        winner = 0;
        rowsSum = new int[n];
        colSum = new int[n];
        diagSum = new int[2];
        size = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {

        //invalid move
        if (winner > 0 || board[row][col] > 0 || player > 2) {
            return 0;
        }
        int currVal = player > 1 ? size + 1 : 1;
        int sumCheck = currVal * size;
        board[row][col] = currVal;
        rowsSum[row] = rowsSum[row] + currVal;
        if (rowsSum[row] == sumCheck) {
            winner = player;
            return player;
        }
        colSum[col] = colSum[col] + currVal;
        if (colSum[col] == sumCheck) {
            winner = player;
            return player;
        }
        if (row == col) {
            diagSum[0] = diagSum[0] + currVal;
            if (diagSum[0] == sumCheck) {
                winner = player;
                return player;
            }
        }
        if (row + col == size - 1) {
            diagSum[1] = diagSum[1] + currVal;
            if (diagSum[1] == sumCheck) {
                winner = player;
                return player;
            }
        }
        return 0;
    }
}

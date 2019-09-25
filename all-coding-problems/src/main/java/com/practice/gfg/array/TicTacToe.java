package com.practice.gfg.array;

public class TicTacToe {

	int[][] board;
	int size;
	final int player1 = 1;
	final int player2 = 2;
	int winner;

	public TicTacToe(int size) {
		this.board = new int[size][size];
		this.size = size;
	}

	public void makeMove(int player, int row, int column) {

		if (row >= size || column >= size || board[row][column] != 0) {
			System.out.println("Illegal move!");
			return;
		}
		board[row][column] = player == 1 ? -1 : 1;
		int rowSum = 0;
		int colSum = 0;
		for (int i = 0; i < size; i++) {
			rowSum = rowSum + Math.abs(board[row][i]);
		}
		
		for (int i = 0; i < size; i++) {
			colSum = colSum + Math.abs(board[i][column]);
		}
		if(rowSum == size || colSum == size) {
			winner = player;
		}

	}

	public static void main(String[] args) {

	}

}

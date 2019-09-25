package com.practice.gfg.array;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sudoku[][] = { { 8, 3, 5, 4, 1, 6, 9, 2, 7 }, { 2, 9, 6, 8, 5, 7, 4, 3, 1 }, { 4, 1, 7, 2, 9, 3, 6, 5, 8 },
				{ 5, 6, 9, 1, 3, 4, 7, 8, 2 }, { 1, 2, 3, 6, 7, 8, 5, 4, 9 }, { 7, 4, 8, 5, 2, 9, 1, 6, 3 },
				{ 6, 5, 2, 7, 8, 1, 3, 9, 4 }, { 9, 8, 1, 3, 4, 5, 2, 7, 6 }, { 3, 7, 4, 9, 6, 2, 8, 1, 5 } };

		int incorrectSudoku[][] = { { 8, 3, 5, 4, 1, 6, 9, 2, 7 }, { 2, 9, 6, 8, 5, 7, 4, 3, 1 },
				{ 4, 1, 7, 2, 9, 3, 6, 5, 8 }, { 5, 6, 9, 1, 3, 4, 7, 8, 2 }, { 1, 2, 3, 6, 7, 8, 5, 4, 9 },
				{ 7, 4, 8, 5, 2, 9, 1, 6, 3 }, { 6, 5, 2, 7, 8, 1, 3, 9, 4 }, { 9, 8, 1, 3, 4, 5, 2, 7, 6 },
				{ 3, 7, 4, 9, 6, 2, 8, 1, 1 } };

		if (isValidSudoku(incorrectSudoku)) {
			System.out.println(" This is valid");
		} else {
			System.out.println("This is not valid!");
		}

	}

	static boolean isValidSudoku(int sudoku[][]) {
		for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				if (!isValid(sudoku, row, column)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(int[][] sudoku, int row, int column) {

		return isValidBox(sudoku, row, column) && isValidRow(sudoku, row, column) && isValidColumn(sudoku, row, column);

	}

	private static boolean isValidBox(int[][] sudoku, int row, int column) {
		int boxRowStart = 0;
		int boxRowEnd = 0;
		int boxColumnStart = 0;
		int boxColumnEnd = 0;
		if (row >= 0 && row < 3) {
			boxRowStart = 0;
			boxRowEnd = 2;
		}
		if (row >= 3 && row < 6) {
			boxRowStart = 3;
			boxRowEnd = 5;
		}
		if (row >= 6 && row < 9) {
			boxRowStart = 6;
			boxRowEnd = 8;
		}
		if (column >= 0 && column < 3) {
			boxColumnStart = 0;
			boxColumnEnd = 2;
		}
		if (column >= 3 && column < 6) {
			boxColumnStart = 3;
			boxColumnEnd = 5;
		}
		if (column >= 6 && column < 9) {
			boxColumnStart = 6;
			boxColumnEnd = 8;
		}
		for (int i = boxRowStart; i <= boxRowEnd; i++) {
			for (int j = boxColumnStart; j <= boxColumnEnd; j++) {
				if (i != row && j != column) {
					if (sudoku[row][column] == sudoku[i][j]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean isValidRow(int[][] sudoku, int row, int column) {
		for (int j = 0; j < 9; j++) {
			if (j != column) {
				if (sudoku[row][column] == sudoku[row][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValidColumn(int[][] sudoku, int row, int column) {
		for (int j = 0; j < 9; j++) {
			if (j != row) {
				if (sudoku[row][column] == sudoku[j][column]) {
					return false;
				}
			}
		}
		return true;
	}

}

package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class NoOfIslands {

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int testCases = fastReader.nextInt();
		for (int test = 0; test < testCases; test++) {
			int row = fastReader.nextInt();
			int column = fastReader.nextInt();
			int[][] arr = new int[row][column];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					arr[i][j] = fastReader.nextInt();
				}
			}
			System.out.println("Number of Islands: " + getNoOfIslands(arr, row, column));
		}
	}

	private static int getNoOfIslands(int[][] arr, int row, int column) {
		int islands = 0;
		boolean[][] visited = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) {
					markAllReachableCells(arr, visited, row, column, i, j);
					islands++;
				}
			}
		}
		return islands;
	}

	private static void markAllReachableCells(int[][] arr, boolean[][] visited, int row, int column, int currRow,
			int currColumn) {
		visited[currRow][currColumn] = true;
		// right
		if (isValidPos(row, column, currRow, currColumn + 1) && arr[currRow][currColumn + 1] == 1
				&& visited[currRow][currColumn + 1] == false) {
			markAllReachableCells(arr, visited, row, column, currRow, currColumn + 1);
		}
		// diagonally down
		if (isValidPos(row, column, currRow + 1, currColumn + 1) && arr[currRow + 1][currColumn + 1] == 1
				&& visited[currRow + 1][currColumn + 1] == false) {
			markAllReachableCells(arr, visited, row, column, currRow + 1, currColumn + 1);
		}
		// down
		if (isValidPos(row, column, currRow + 1, currColumn) && arr[currRow + 1][currColumn] == 1
				&& visited[currRow + 1][currColumn] == false) {
			markAllReachableCells(arr, visited, row, column, currRow + 1, currColumn);
		}

	}

	private static boolean isValidPos(int row, int column, int currRow, int currColumn) {
		return currRow >= 0 && currRow < row && currColumn >= 0 && currColumn < column;
	}

}

package com.practice.array;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	class Pair {

		int row;
		int column;

		public Pair(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int testCases = fr.nextInt();
		RottenOranges ro = new RottenOranges();
		for (int i = 0; i < testCases; i++) {
			int rows = fr.nextInt();
			int columns = fr.nextInt();
			int[][] table = new int[rows][columns];
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					table[j][k] = fr.nextInt();
				}
			}
			System.out.println(ro.getRottenTime(table, rows, columns));

		}
	}

	private int getRottenTime(int[][] table, int rows, int columns) {
		int rotTime = 0;
		Queue<Pair> queue = new LinkedList<Pair>();

		// Initialize queue with all initial rotten oranges
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < columns; k++) {
				if (table[j][k] == 2) {
					queue.add(new Pair(j, k));
				}
			}
		}
		// Mark the end of one Day
		if (!queue.isEmpty()) {
			queue.add(new Pair(-1, -1));
		}

		Pair prevPair = null;
		while (!queue.isEmpty()) {
			Pair currPair = queue.remove();
			if (currPair.getRow() == -1 && currPair.getColumn() == -1) {
				if (prevPair != null && prevPair.getRow() == -1 && prevPair.getColumn() == -1) {
					rotTime--;
					break;
				}
				rotTime++;
				queue.add(new Pair(-1, -1));
			} else {
				this.rotAndAddAllAdjacentFreshItems(table, currPair, queue);
			}
			prevPair = currPair;
		}

		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < columns; k++) {
				if (table[j][k] == 1) {
					rotTime = -1;
				}
			}
		}
		return rotTime;
	}

	private void rotAndAddAllAdjacentFreshItems(int[][] table, Pair currPair, Queue<Pair> queue) {

		// UP
		if (currPair.getRow() > 0 && table[currPair.getRow() - 1][currPair.getColumn()] == 1) {
			table[currPair.getRow() - 1][currPair.getColumn()] = 2;
			queue.add(new Pair(currPair.getRow() - 1, currPair.getColumn()));

		}

		// Left
		if (currPair.getColumn() > 0 && table[currPair.getRow()][currPair.getColumn() - 1] == 1) {
			table[currPair.getRow()][currPair.getColumn() - 1] = 2;
			queue.add(new Pair(currPair.getRow(), currPair.getColumn() - 1));

		}

		// Down
		if (currPair.getRow() < table.length - 1 && table[currPair.getRow() + 1][currPair.getColumn()] == 1) {
			table[currPair.getRow() + 1][currPair.getColumn()] = 2;
			queue.add(new Pair(currPair.getRow() + 1, currPair.getColumn()));

		}

		// Right
		if (currPair.getColumn() < table[0].length - 1 && table[currPair.getRow()][currPair.getColumn() + 1] == 1) {
			table[currPair.getRow()][currPair.getColumn() + 1] = 2;
			queue.add(new Pair(currPair.getRow(), currPair.getColumn() + 1));

		}

	}

}

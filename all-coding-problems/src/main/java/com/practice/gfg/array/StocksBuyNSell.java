package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class StocksBuyNSell {

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		int test = fr.nextInt();
		for (int i = 0; i < test; i++) {
			int size = fr.nextInt();
			int arr[] = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = fr.nextInt();
			}
			printBuySellDays(arr);
			System.out.println();
		}

	}

	private static void printBuySellDays(int[] arr) {
		// TODO Auto-generated method stub
		boolean buy = true;
		int buyDay = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (buy) {
				if (arr[i] < arr[i + 1]) {
					buyDay = i;
					buy = false;
				}
			} else {
				if (arr[i] > arr[i + 1]) {
					System.out.print("(" + buyDay + " " + i + ") ");
					buy = true;
				}
			}
		}
		if(buy == false) {
			System.out.print("(" + buyDay + " " + (arr.length - 1) + ") ");
		}

	}

}

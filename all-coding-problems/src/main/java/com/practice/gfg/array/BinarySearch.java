package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class BinarySearch {

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		int test = fr.nextInt();
		for (int i = 0; i < test; i++) {
			int num = fr.nextInt();
			int arr[] = new int[num];
			for (int j = 0; j < num; j++) {
				arr[j] = fr.nextInt();
			}
			int key = fr.nextInt();
			System.out.println(binarySearch(arr, key));
		}

	}

	private static int binarySearch(int[] arr, int key) {

		int index = -1;
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] == key) {
				index = mid;
				break;
			}
			if (key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

}

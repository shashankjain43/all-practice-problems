package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class ElementFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FastReader fr = new FastReader();
		int test = fr.nextInt();
		for (int i = 0; i < test; i++) {
			int size = fr.nextInt();
			int arr[] = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = fr.nextInt();
			}
			elementFromArray(arr);
		}

	}

	private static void elementFromArray(int[] arr) {
		
		
		
		
	}

}

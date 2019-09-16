package com.practice.array;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Water trapped is: " + getTrappedWater(arr));

	}

	private static int getTrappedWater(int[] arr) {
		// TODO Auto-generated method stub
		int water = 0;
		int size = arr.length;
		int currMaxFromLeft = arr[0];
		int maxFromLeft[] = new int[size];
		maxFromLeft[0] = currMaxFromLeft;
		
		int currMaxFromRight = arr[size - 1];
		int maxFromRight[] = new int[size];
		maxFromRight[size - 1] = currMaxFromRight;
		for (int i = 1; i < size; i++) {
			if (currMaxFromLeft > arr[i]) {
				maxFromLeft[i] = currMaxFromLeft;
			} else {
				currMaxFromLeft = arr[i];
				maxFromLeft[i] = arr[i];
			}
			
			if (currMaxFromRight > arr[size - i]) {
				maxFromRight[size - i] = currMaxFromRight;
			} else {
				currMaxFromRight = arr[size - i];
				maxFromRight[size - i] = arr[size - i];
			}
		}
		for (int i = 0; i < size; i++) {
			if(Math.min(maxFromLeft[i], maxFromRight[i]) > arr[i]) {
				water = water + Math.abs(Math.min(maxFromLeft[i], maxFromRight[i])-arr[i]);
			}
		}
		return water;
	}

}

package com.practice.array;

public class TrappingRainWater {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int test = fr.nextInt();
		for (int i = 0; i < test; i++) {
			int size = fr.nextInt();
			int arr[] = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = fr.nextInt();
			}
			System.out.println(getTrappedWater(arr));
		}
	}

    private static int getTrappedWater(int[] arr) {
        int water = 0;
        int size = arr.length;
        int currMaxFromLeft = Integer.MIN_VALUE;
        int currMaxFromRight = Integer.MIN_VALUE;
        int maxFromLeft[] = new int[size];
        int maxFromRight[] = new int[size];

        for (int i = 0; i < size; i++) {
            if (arr[i] > currMaxFromLeft) {
                maxFromLeft[i] = arr[i];
                currMaxFromLeft = arr[i];
            } else {
                maxFromLeft[i] = currMaxFromLeft;
            }
            if (arr[size - i - 1] > currMaxFromRight) {
                maxFromRight[size - i - 1] = arr[size - i - 1];
                currMaxFromRight = arr[size - i - 1];
            } else {
                maxFromRight[size - i - 1] = currMaxFromRight;
            }
        }
        for (int i = 0; i < size; i++) {
            if (Math.min(maxFromLeft[i], maxFromRight[i]) > arr[i]) {
                water = water + Math.abs(Math.min(maxFromLeft[i], maxFromRight[i]) - arr[i]);
            }
        }
        return water;
    }

}

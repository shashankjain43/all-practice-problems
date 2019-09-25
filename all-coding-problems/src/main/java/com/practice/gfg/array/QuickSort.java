package com.practice.gfg.array;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 90, 10, 45, 8, 99, 11, 1, 78, 2 };
		quickSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void quickSort(int[] arr) {
		quickSortUtil(arr, 0, arr.length - 1);
	}

	private static void quickSortUtil(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);
			quickSortUtil(arr, low, pivotIndex - 1);
			quickSortUtil(arr, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// lets take last element as pivot
		int pivot = arr[high];
		int smallerIndex = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				smallerIndex++;
				int temp = arr[j];
				arr[j] = arr[smallerIndex];
				arr[smallerIndex] = temp;
			}
		}
		int temp = arr[high];
		arr[high] = arr[smallerIndex + 1];
		arr[smallerIndex + 1] = temp;
		return smallerIndex + 1;
	}

}

package com.practice.gfg.array;

import com.practice.gfg.FastReader;

import java.util.Deque;
import java.util.LinkedList;

public class LeadersOfArray {

	public static void main(String[] args) {

		FastReader fr = new FastReader();
		int test = fr.nextInt();
		for (int i = 0; i < test; i++) {
			int size = fr.nextInt();
			int arr[] = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = fr.nextInt();
			}
			printLeaders(arr);
		}
	}

	private static void printLeaders(int[] arr) {
		int maxFromLeft = Integer.MIN_VALUE;
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] >= maxFromLeft) {
				maxFromLeft = arr[i];
				stack.push(arr[i]);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
}

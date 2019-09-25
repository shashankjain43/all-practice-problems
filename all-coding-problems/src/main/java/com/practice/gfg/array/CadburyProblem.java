package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class CadburyProblem {

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int l1 = fastReader.nextInt();
		int l2 = fastReader.nextInt();
		int b1 = fastReader.nextInt();
		int b2 = fastReader.nextInt();
		if (l2 < l1 || b2 < b1) {
			return;
		}
		int size = (l2 - l1 + 1) * (b2 - b1 + 1);
		int len[] = new int[size];
		int bre[] = new int[size];
		int i = 0;
		while (i < size) {
			for (int j = l1; j <= l2; j++) {
				for (int k = b1; k <= b2; k++) {
					len[i] = j;
					bre[i] = k;
					i++;
				}
			}
		}
		System.out.println(getStudentsFeed(len, bre, size) + "");

	}

	private static int getStudentsFeed(int[] len, int[] bre, int size) {
		int students = 0;
		for (int i = 0; i < size; i++) {
			while (len[i] != bre[i]) {
				if (len[i] > bre[i]) {
					len[i] = len[i] - bre[i];
				} else {
					bre[i] = bre[i] - len[i];
				}
				students++;
			}
			students++;
		}
		return students;
	}

}

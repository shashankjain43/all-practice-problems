package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class SongPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> songs = new ArrayList<String>();
		songs.add("a");
		songs.add("b");
		songs.add("c");
		songs.add("d");
		songs.add("e");

		System.out.println(playlist(songs, 2, "b"));

	}

	public static int playlist(List<String> songs, int k, String q) {
		// Write your code here
		int firstPos = songs.indexOf(q);
		int lastPos = songs.lastIndexOf(q);

		System.out.println("Fist position: " + firstPos);
		System.out.println("Last position: " + lastPos);

		if (firstPos == lastPos) {
			if (firstPos > k) {
				return Math.min(firstPos - k, songs.size() - firstPos + k);
			} else {
				return Math.min(k - firstPos, songs.size() - k + firstPos);
			}
		}

		if (k > firstPos && k < lastPos) {
			return Math.min(Math.abs(k - firstPos), Math.abs(k - lastPos));
		}
		if (firstPos > -1 && k < firstPos) {
			return Math.abs(k - firstPos);
		}

		if (firstPos > -1 && k > firstPos) {
			return songs.size() - k + firstPos;
		}

		return 0;
	}
}

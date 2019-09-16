package com.practice.array;

import java.util.Arrays;

public class NMeetingsInOneRoom {

	static class Meeting implements Comparable<Meeting> {
		
		int index;

		int start;
		int finish;

		@Override
		public int compareTo(Meeting o) {
			if (this.finish < o.finish) {
				return -1;
			} else if (this.finish > o.finish) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int testCases = fr.nextInt();
		for (int i = 0; i < testCases; i++) {
			int num = fr.nextInt();
			Meeting[] schedule = new Meeting[num];
			for (int j = 0; j < num; j++) {
				Meeting meeting = new Meeting();
				meeting.index = j+1;
				meeting.start = fr.nextInt();
				schedule[j] = meeting;
			}
			for (int j = 0; j < num; j++) {
				schedule[j].finish = fr.nextInt();
			}

			Arrays.sort(schedule);

			System.out.println("Maximum Meetings possible is: " + getMaxMeetings(schedule));

			for (int j = 0; j < num; j++) {
				System.out.print("Start: " + schedule[j].start);
				System.out.println(" Finish: " + schedule[j].finish);
			}

		}

	}

	private static int getMaxMeetings(Meeting[] schedule) {
		// TODO Auto-generated method stub
		int max = 1;
		int prevFinish = schedule[0].finish;
		System.out.println("Next Meeting number: " + 1);
		for (int j = 1; j < schedule.length;j++) {
			if (schedule[j].start > prevFinish) {
				max = max + 1;
				prevFinish = schedule[j].finish;
				System.out.println("Next Meeting number: " + schedule[j].index);
			}
		}

		return max;
	}

}
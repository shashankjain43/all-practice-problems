package com.practice.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Test implements Comparable<Test> {

	public static void main(String[] args) {
		Queue<String> pq = new PriorityQueue<String>();
		Queue<Integer> q = new LinkedList<Integer>();

		Map<String, Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				if (o1.length() == o2.length()) {
					return 0;
				}
				if (o1.length() > o2.length()) {
					return 1;
				}
				return -1;
			}
		});
		map.put("A", 98);
		map.put("Cada", 98);
		map.put("Dasadad", 98);
		map.put("Bs", 98);
		map.put("E", 98);
		for (Entry<String, Integer> s : map.entrySet()) {
			System.out.println(s.getKey() + ":  " + s.getValue());
		}
		for (String s : map.keySet()) {
			System.out.println(s + ": " + map.get(s));
		}

		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		Map<String, Integer> newMap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			newMap.put(entry.getKey(), entry.getValue());
		}

	}

	@Override
	public int compareTo(Test o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

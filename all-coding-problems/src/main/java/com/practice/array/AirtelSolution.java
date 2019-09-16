package com.practice.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AirtelSolution {

	public static void main(String[] args) {
		List<Integer> cityFrom = new LinkedList<Integer>();
		List<Integer> cityTo = new LinkedList<Integer>();
		List<Integer> cityWeight = new LinkedList<Integer>();
		cityFrom.add(1);
		cityFrom.add(1);
		cityFrom.add(1);
		cityFrom.add(2);
		cityFrom.add(2);
		cityFrom.add(3);
		
		cityTo.add(2);
		cityTo.add(3);
		cityTo.add(4);
		cityTo.add(3);
		cityTo.add(4);
		cityTo.add(4);
		
		cityWeight.add(1);
		cityWeight.add(3);
		cityWeight.add(2);
		cityWeight.add(1);
		cityWeight.add(1);
		cityWeight.add(1);
		
		System.out.println(findCapitalCity(1, 6, cityFrom, cityTo, cityWeight));

	}

	public static int findCapitalCity(int robber_distance, int cityNodes, List<Integer> cityFrom, List<Integer> cityTo,
			List<Integer> cityWeight) {

		int capitalCity = 0;
		Map<Integer,Integer> sortedCount = new TreeMap<Integer,Integer>();
		for (int i = 0; i < cityNodes; i++) {
			if(cityWeight.get(i) <= robber_distance) {
				if(sortedCount.containsKey(cityFrom.get(i))) {
					sortedCount.put(cityFrom.get(i), sortedCount.get(cityFrom.get(i)) +1);
				} else {
					sortedCount.put(cityFrom.get(i), 1);
				}
				
				if(sortedCount.containsKey(cityTo.get(i))) {
					sortedCount.put(cityTo.get(i), sortedCount.get(cityTo.get(i)) +1);
				} else {
					sortedCount.put(cityTo.get(i), 1);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int j: sortedCount.keySet()) {
			if(sortedCount.get(j) <= min) {
				min = sortedCount.get(j);
				capitalCity = j;
			}
		}
		return capitalCity;

	}

}

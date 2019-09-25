package com.practice.gfg.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int v;
	private LinkedList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void DFS(int start) {
		boolean visited[] = new boolean[v];
		DFSUtil(start, visited);
	}

	private void DFSUtil(int start, boolean[] visited) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int neighbour : adj[start]) {
			if (visited[neighbour] == false) {
				DFSUtil(neighbour, visited);
			}
		}
	}

	public void BFS(int start) {
		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int curr = queue.remove();
			if (visited[curr] == false) {
				System.out.print(curr + " ");
				visited[curr] = true;
				for (int n : adj[curr]) {
					queue.add(n);
				}
			}
		}
	}

	public boolean isCyclic() {
		int colors[] = new int[v];
		for (int i = 0; i < v; i++) {
			colors[i] = 0;// marking white
		}
		// check for each disconnected component
		for (int i = 0; i < v; i++) {
			if (colors[i] == 0 && isCyclicUtil(i, colors)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int curr, int[] colors) {

		// mark current as Grey
		colors[curr] = 2;
		for (int neighbour : adj[curr]) {

			// Check for back edge
			if (colors[neighbour] == 2) {
				return true;
			}
			if (colors[neighbour] == 1 && isCyclicUtil(neighbour, colors)) {
				return true;
			}
		}
		colors[curr] = 3;
		return false;
	}

	public void topoSort() {
		boolean visited[] = new boolean[v];
		Deque<Integer> stack = new LinkedList<Integer>();

		for (int i = 0; i < v; i++) {
			if (visited[i] == false) {
				topoSortUtil(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}
	}

	private void topoSortUtil(int i, boolean[] visited, Deque<Integer> stack) {

		visited[i] = true;
		for (int neighbour : adj[i]) {
			System.out.println(" Neighbour of " + i + " is " + neighbour);
			if (visited[neighbour] == false) {
				topoSortUtil(neighbour, visited, stack);
			}
		}
		stack.push(i);
	}

	public static void main(String[] args) {
		/*
		 * Graph g = new Graph(5); g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 2);
		 * g.addEdge(1, 4); g.addEdge(2, 0); g.addEdge(2, 3); g.addEdge(3, 3);
		 * g.addEdge(4, 3);
		 */

		// g.DFS(0);
		// g.BFS(2);
		/*
		 * if (g.isCyclic()) { System.out.println("This Graph has cycle"); } else {
		 * System.out.println("This Graph don't have cycle"); }
		 */

		String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		Graph graph = new Graph(4);

		for (int i = 0; i < words.length - 1; i++) {
			// Take the current two words and find the first mismatching
			// character
			String word1 = words[i];
			String word2 = words[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				// If we find a mismatching character, then add an edge
				// from character of word1 to that of word2
				if (word1.charAt(j) != word2.charAt(j)) {
					//check for a reverse edge
					if (graph.hasEdge(word2.charAt(j) - 'a', word1.charAt(j) - 'a')) {
						System.out.println("Invalid Input");
						return;
					}
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}
		graph.topoSort();
	}

	private boolean hasEdge(int source, int dest) {
		
		return adj[source].contains(dest);
	}

}
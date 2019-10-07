package com.practice.gfg.graph;

import java.util.*;

public class Graph {

    int nodes, edges;
    List<Integer> adj[];
    Edge[] edgeArr;
    int edgeIndex = -1;

    public Graph(int nodes, int edges) {
        this.nodes = nodes;
        adj = new List[nodes];
        edgeArr = new Edge[edges];
        for (int i = 0; i < nodes; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph(int nodes) {
        this.nodes = nodes;
        adj = new List[nodes];
        for (int i = 0; i < nodes; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        if (source < nodes) {
            adj[source].add(dest);
            edgeArr[++edgeIndex] = new Edge(source, dest);
        }
    }

    public void dfs(int source) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[nodes];
        visited[source] = true;
        stack.push(source);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                System.out.print(v + " ");
            }
            visited[v] = true;
            for (Integer i : adj[v]) {
                if (!visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    public void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes];
        queue.add(source);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (!visited[v]) {
                System.out.print(v + " ");
            }
            visited[v] = true;
            for (Integer i : adj[v]) {
                if (!visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }

    public boolean isCyclic() {

        int[] parent = new int[nodes];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges; i++) {
            int sourceFind = find(edgeArr[i].source, parent);
            int destFind = find(edgeArr[i].dest, parent);

            if (sourceFind == destFind) {
                return true;
            } else {
                union(sourceFind, destFind, parent);
            }
        }
        return false;
    }

    private void union(int sourceFind, int destFind, int[] parent) {
        int source = find(sourceFind, parent);
        int dest = find(destFind, parent);
        parent[source] = dest;
    }

    private int find(int source, int[] parent) {

        while (parent[source] != source) {
            source = parent[source];
        }
        return source;
    }

    public void topoSort() {

        Deque<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (visited[i] == false) {
                topoSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                topoSortUtil(i, visited, stack, list);
            }
        }

        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return arr;
    }

    private static void topoSortUtil(int i, boolean[] visited, Deque<Integer> stack, ArrayList<ArrayList<Integer>> list) {

        visited[i] = true;
        for (int j = 0; j < list.get(i).size(); j++) {
            if (visited[list.get(i).get(j)] == false) {
                topoSortUtil(list.get(i).get(j), visited, stack, list);
            }
        }
        stack.push(i);
    }

    private void topoSortUtil(int i, boolean[] visited, Deque<Integer> stack) {
        visited[i] = true;
        for (int j = 0; j < adj[i].size(); j++) {
            if (visited[adj[i].get(j)] == false) {
                topoSortUtil(adj[i].get(j), visited, stack);
            }
        }
        stack.push(i);
    }

    class Edge {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}

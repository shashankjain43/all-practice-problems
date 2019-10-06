package com.practice.gfg.graph;

import com.practice.gfg.FastReader;

public class BFS {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int nodes = fr.nextInt();
            int edges = fr.nextInt();
            Graph graph = new Graph(nodes);
            for (int j = 0; j < edges; j++) {
                int source = fr.nextInt();
                int dest = fr.nextInt();
                graph.addEdge(source, dest);
            }
            graph.bfs(0);
            System.out.println();
        }
    }
}

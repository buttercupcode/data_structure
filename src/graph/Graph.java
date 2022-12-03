package graph;

import java.util.LinkedList;

public class Graph {
    int v;
    LinkedList<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }
}

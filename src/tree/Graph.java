package tree;

import java.util.LinkedList;

public class Graph {
    int v;
    LinkedList<Integer>[] adj;

    public Graph(int ver) {
        v = ver;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(Graph g, int u, int v) {
        g.adj[u].add(v);

    }

    boolean DFSUtil(Graph g, int u, int[] color) {
        color[u] = 1;
        for (Integer i : adj[u]) {
            if (color[i] == 1)
                return true;
            if (color[i] == 1 && DFSUtil(g, i, color))
                return true;
        }
        color[u] = 2;
        return false;

    }

    enum Color {
        GRAY,//1,
        BLACK, //2
        WHITE//0
    }
}

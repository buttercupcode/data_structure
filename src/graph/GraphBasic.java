package graph;

import java.util.*;

public class GraphBasic {
    public static void main(String[] args) {
        GraphBasic gb = new GraphBasic();

        /// test basic iteration
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        gb.BFSGraph(2, g);

        System.out.println(gb.validPathBFS(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
        System.out.println(gb.validPathDFS(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }

    public void BFSGraph(int s, Graph graph) {
        // Create a queue for BFS
        boolean[] visited = new boolean[graph.v];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");
            LinkedList<Integer> linkedVertices = graph.adj[s];
            for (int i : linkedVertices) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (vertex == destination)
                return true;
            List<Integer> vertexes = graph.get(vertex);

            for (Integer i : vertexes) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return false;
    }

    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfsGraph(graph, visited, source, destination);
    }

    public boolean dfsGraph(Map<Integer, List<Integer>> graph, boolean[] visited, int currentNode, int destination) {
        if (currentNode == destination)
            return true;
        List<Integer> adjoins = graph.get(currentNode);
        if (!visited[currentNode]) {
            visited[currentNode] = true;
            for (Integer vertex : adjoins) {
                if (dfsGraph(graph, visited, vertex, destination))
                    return true;
            }
        }
        return false;

    }
}


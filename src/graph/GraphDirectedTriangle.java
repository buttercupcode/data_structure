package graph;

/**
 * Java program to find number
 * of triangles in an Undirected
 * Graph. The program is for
 * adjacency matrix representation
 * of the graph
 */
public class GraphDirectedTriangle {
    int V = 4;

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };
        GraphDirectedTriangle dt = new GraphDirectedTriangle();
        System.out.println("Total number of Triangle in Graph : " +
                dt.triangleInGraph(graph));

    }

    public int triangleInGraph(int[][] graph) {
        // To Store graph^2
        int[][] aux2 = new int[V][V];

        // To Store graph^3
        int[][] aux3 = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                aux2[i][j] = aux3[i][j] = 0;
            }
        }
        multiply(graph, graph, aux2);
        multiply(graph, aux2, aux3);
        int trace = getTrace(aux3);

        return trace / 6;
    }

    public void multiply(int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                C[i][j] = 0;
                for (int k = 0; k < V; k++) {
                    C[i][j] += A[i][k] *
                            B[k][j];
                }
            }
        }
    }

    // Utility function to calculate
    // trace of a matrix (sum of
    // diagonal elements)
    int getTrace(int[][] graph) {
        int trace = 0;

        for (int i = 0; i < V; i++) {
            trace += graph[i][i];
        }
        return trace;
    }
}

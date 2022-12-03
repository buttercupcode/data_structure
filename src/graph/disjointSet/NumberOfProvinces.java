package graph.disjointSet;

public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        System.out.println(np.findCircleNum2(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        NumberOfProvinces.UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();

    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    class UnionFind {
        int[] rank, parent;
        private int count;

        UnionFind(int n) {
            count = n;
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = parent[p];
            int rootQ = parent[q];
            if (rootQ == rootP)
                return;
            if (rank[rootQ] > rank[rootP])
                parent[rootP] = rootQ;
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ])
                    rank[rootP]++;
            }
            count--;

        }

        public int count() {
            return count;
        }
    }
}

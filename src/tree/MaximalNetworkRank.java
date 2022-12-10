package tree;

public class MaximalNetworkRank {
    public static void main(String[] args) {
        MaximalNetworkRank mr = new MaximalNetworkRank();
        System.out.println(mr.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] roadsFrom = new int[n];
        int[][] network = new int[n][n];
        for (int[] arr : roads) {
            int src = arr[0];
            int dest = arr[1];
            roadsFrom[src]++;
            roadsFrom[dest]++;
            network[src][dest] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = roadsFrom[i] + roadsFrom[j] - network[i][j] - network[j][i];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

package graph.disjointSet;

public class FindJudge {
    public static void main(String[] args) {
        FindJudge fj = new FindJudge();
        System.out.println(fj.findJudge(3, new int[][]{{1, 2}, {2, 3}}));
    }

    public int findJudge(int n, int[][] trusts) {
        int[][] matrix = new int[n][n];
        int[] count = new int[n];

        for (int[] trust : trusts) {
            int i = trust[0], j = trust[1];
            matrix[i - 1][j - 1] = 1;
            count[j - 1]++;
        }
        int judgeLoc = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] == n - 1) {
                judgeLoc = i;
                break;
            }
        }
        if (judgeLoc == -1)
            return judgeLoc;
        for (int i = 0; i < n; i++) {
            if (matrix[judgeLoc][i] != 0)
                return -1;
        }
        return judgeLoc + 1;
    }

    public int findJudge2(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}

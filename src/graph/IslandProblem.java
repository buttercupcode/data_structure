package graph;

public class IslandProblem {
    public static void main(String[] args) {
        IslandProblem ni = new IslandProblem();
        System.out.println(ni.numIslands(new char[][]

                //{{'1','1','1'},{'0','1','0'},{'1','1','1'}}
                /*{{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}}*/
                //{{'1','0'},{'0','1'}}
                {
                        {'1', '1', '0'},
                        {'0', '1', '0'},
                        {'0', '0', '1'}
                }
        ));
        System.out.println(ni.maxAreaOfIsland(new int[][]
                // {{1,1,0},                {0,1,0},                {0,0,1}}
                {{1, 1, 1}, {0, 1, 0}, {1, 1, 1}}
        ));
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        if (visited[i][j])
            return;
        visited[i][j] = true;
        if (grid[i][j] == '1') {
            dfs(grid, visited, i, j + 1);
            dfs(grid, visited, i + 1, j);
            dfs(grid, visited, i, j - 1);
            dfs(grid, visited, i - 1, j);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfsArea(grid, visited, i, j));

                }
            }
        }
        return maxArea;
    }

    public int dfsArea(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;
        int sum = 0;
        if (grid[i][j] == 1) {
            sum = 1;
            sum += dfsArea(grid, visited, i, j + 1);
            sum += dfsArea(grid, visited, i + 1, j);
            sum += dfsArea(grid, visited, i, j - 1);
            sum += dfsArea(grid, visited, i - 1, j);
        }
        return sum;
    }
}

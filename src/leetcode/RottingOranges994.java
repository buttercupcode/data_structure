package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges994 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottingOranges994 r = new RottingOranges994();
        System.out.println(r.orangesRotting(test));
    }

    public int orangesRotting(int[][] grid) {
        int mins = 0;
        int initial_fresh = 0, spoiled = 0;
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    addToQueue(i, j, queue, grid);
                } else if (grid[i][j] == 1) {
                    initial_fresh++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean fresh = false;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if (grid[r][c] == 1) {
                    fresh = true;
                    grid[r][c] = 2;
                    spoiled++;
                    addToQueue(r, c, queue, grid);
                }
            }
            if (fresh)
                mins++;
        }
        return initial_fresh == spoiled ? mins : -1;

    }

    private void addToQueue(int i, int j, Queue<int[]> queue, int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (i + 1 < ROWS && grid[i + 1][j] == 1)
            queue.offer(new int[]{i + 1, j});
        if (i - 1 >= 0 && grid[i - 1][j] == 1)
            queue.offer(new int[]{i - 1, j});
        if (j + 1 < COLS && grid[i][j + 1] == 1)
            queue.offer(new int[]{i, j + 1});
        if (j - 1 >= 0 && grid[i][j - 1] == 1)
            queue.offer(new int[]{i, j - 1});
    }
}
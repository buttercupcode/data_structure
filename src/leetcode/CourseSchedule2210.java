package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2210 {
    public static void main(String[] args) {
        CourseSchedule2210 cs = new CourseSchedule2210();
        int[] out = cs.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(out);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        return solveByDfs(incLinkCounts, adjs);
    }

    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = incLinkCounts.length;
        while (n-- > 0)
            adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);

        }
    }

    private int[] solveByDfs(int[] incLinkCounts, List<List<Integer>> adjs) {
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0)
                    toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }
}

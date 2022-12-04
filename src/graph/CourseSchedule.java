package graph;

import java.util.*;
import java.util.stream.IntStream;

public class CourseSchedule {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    private boolean isPossible;
    private Map<Integer, Integer> color;
    private Map<Integer, List<Integer>> adjList;
    private List<Integer> topologicalOrder;

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        //cs.canFinish(2, new int[][]{{1,0}});
        int[][] test = new int[][]
                {{0, 1}, {1, 3}, {1, 4}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println(cs.canFinish(8, test));
        cs.findOrder(8, test);
    }

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] degree = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(0, numCourses).forEach(num -> graph.add(new ArrayList<>()));
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int act = prerequisite[1];
            (graph.get(pre) == null ? new ArrayList<Integer>() : graph.get(pre)).add(act);
            degree[act]++;

        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < graph.get(course).size(); i++) {
                int pointer = graph.get(course).get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                    count++;
                }
            }
        }
        return count == numCourses;
        //return false;
        /*int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int ready = prerequisite[1];
            if (matrix[pre][ready] == 0)
                inDegree[pre]++;
            matrix[pre][ready] = 1;
        }
        int count=0;
        Queue<Integer> queue= new LinkedList<>();
        for(int i =0; i< inDegree.length;i++)
            if(inDegree[i]==0)
                queue.offer(i);
        while (!queue.isEmpty()){
            int course= queue.poll();
            count++;
            for(int i=0;i<numCourses;i++){
                if(matrix[course][i]!=0){
                    if(--inDegree[i]==0)
                        queue.offer(i);
                }
            }
        }
        return count==numCourses;*/
    }

    //  index 1 is prerequisite for 0
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        this.init(numCourses);

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }
        for (int i = 0; i < numCourses; i++) {
            if (this.color.get(i) == WHITE)
                this.dfs(i);
        }
        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = this.topologicalOrder.get(numCourses - 1 - i);
            }
        } else {
            order = new int[0];
        }
        return order;
    }

    private void dfs(int node) {
        if (!this.isPossible)
            return;
        this.color.put(node, GRAY);
        for (Integer adj : adjList.getOrDefault(node, new ArrayList<>())) {
            if (this.color.get(adj) == WHITE)
                this.dfs(adj);
            if (this.color.get(adj) == GRAY)
                this.isPossible = false;
        }
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrderQueue(int numOfCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numOfCourses];
        int[] topologicalOrder = new int[numOfCourses];
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> adjacency = graph.getOrDefault(src, new ArrayList<>());
            adjacency.add(dest);
            graph.put(src, adjacency);
            inDegrees[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            topologicalOrder[count++] = node;
            graph.getOrDefault(node, new ArrayList<>()).forEach(adjNode -> {
                inDegrees[adjNode]--;
                if (inDegrees[adjNode] == 0)
                    queue.offer(adjNode);
            });
        }
        return (count == numOfCourses) ? topologicalOrder : new int[0];

    }
}

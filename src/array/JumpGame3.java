package array;

public class JumpGame3 {

    public static void main(String[] args) {
        JumpGame3 jg3 = new JumpGame3();
        System.out.println(jg3.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        boolean result = dfs(arr, visited, start);
        System.out.println();
        return result;
    }

    public boolean dfs(int[] arr, boolean[] visited, int start) {
        if (start >= arr.length || start < 0 || visited[start])
            return false;
        if (arr[start] == 0) {
            System.out.print(start + "  <- index ");
            return true;
        }
        visited[start] = true;
        boolean right = dfs(arr, visited, start + arr[start]);
        boolean left = dfs(arr, visited, start - arr[start]);

        return left || right;
    }
}

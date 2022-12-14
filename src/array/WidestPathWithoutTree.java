package array;

import java.util.Arrays;

public class WidestPathWithoutTree {
    public static void main(String[] args) {
        WidestPathWithoutTree w = new WidestPathWithoutTree();
        System.out.println(w.widestPAthWithoutTrees(new int[]{4, 1, 5, 4}, new int[]{3, 4, 5, 1, 3, 7}));


    }

    public int widestPAthWithoutTrees(int[] x, int[] y) {
        int max = 0;
        Arrays.sort(x);
        for (int i = 0; i < x.length - 1; i++) {
            max = Math.max(max, x[i + 1] - x[i]);
        }
        return max;
    }
}

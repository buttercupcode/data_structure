package array;

import java.util.HashSet;
import java.util.Set;

public class LargestKAndMinusK {

    public static void main(String[] args) {
        LargestKAndMinusK l = new LargestKAndMinusK();
        System.out.println(l.findMax(new int[]{1, 2, 3, -4}, 2, 3));
    }

    int findMax(int[] arr, int L, int R) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            int k = Math.abs(j);
            if (k >= L && k <= R) {
                if (set.contains(j * (-1)))
                    max = Math.max(max, k);
                set.add(j);
            }
        }
        return max;
    }
}

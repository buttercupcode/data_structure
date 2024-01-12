package questions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] sum = new int[]{2, 7, 11, 15};
        int[] out = ts.twoSum(sum, 9);
        System.out.println(out);
    }

    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.get(diff) != null)
                return new int[]{map.get(diff), i};
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}

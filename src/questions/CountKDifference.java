package questions;

import java.util.HashMap;
import java.util.Map;

public class CountKDifference {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1};
        int diff = 1;
        CountKDifference k = new CountKDifference();
        int i = k.kDiff(arr, diff);
        System.out.println(i);
    }

    public int kDiff(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] + diff))
                result += map.get(arr[i] + diff);
            if (map.containsKey(arr[i] - diff))
                result += map.get(arr[i] - diff);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return result;
    }
}

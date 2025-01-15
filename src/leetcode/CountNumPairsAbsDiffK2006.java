package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumPairsAbsDiffK2006 {
    public static void main(String[] args) {
        CountNumPairsAbsDiffK2006 k = new CountNumPairsAbsDiffK2006();
    }

    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    int diff = nums[i] >= nums[j] ? nums[i] - nums[j] : nums[j] - nums[i];
                    if (diff == k)
                        count++;
                }
            }
            result += count;
        }
        return result;
    }

    public int countKDifferenceCountingSort(int[] nums, int k) {
        int[] idx = new int[101];
        int result = 0;
        for (int n : nums) {
            idx[n]++;
        }
        for (int i = 0; i < idx.length; i++) {
            if (i - k > 0) {
                result += idx[i] * idx[i - k];
            }
        }
        return result;
    }

    public int countKDifferenceMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            if (map.containsKey(i - k)) {
                res += map.get(i - k);
            }
            if (map.containsKey(i + k)) {
                res += map.get(i + k);
            }

            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return res;
    }

}

package questions.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        SubArraySumK k = new SubArraySumK();
        int s = 0;
        s = k.subArraySumMap(arr, 2);
        s = k.subArraySumMap(new int[]{1, 2, 3}, 3);
        s = k.subArraySumMap(new int[]{1}, 0);
        s = k.subArraySumMap(new int[]{-1, -1, 1}, 0);
        System.out.println(s);
    }

    public int subArraySumMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /***
     * approach doesnt work
     * @param nums
     * @param k
     * @return
     */
    public int subArraySum(int[] nums, int k) {
        int i = 0, j = 0;
        int count = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];

            while (sum >= k && i < nums.length) {
                if (sum == k)
                    count++;
                sum -= nums[i];
                i++;
            }
            j++;
        }
        while (i < nums.length) {
            sum -= nums[i++];
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}

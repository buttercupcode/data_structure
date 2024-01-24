package questions.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        int i = lc.longestConsecutiveMap(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        //int i = lc.longestConsecutiveMap(new int[]{100,4,200,1,3,2});
        System.out.println(i);
    }

    public int longestConsecutiveSet(int[] nums) {
        int maxOccurrence = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int y = i + 1;
                while (set.contains(y))
                    y += 1;
                maxOccurrence = Math.max(maxOccurrence, y - i);

            }

        }
        return maxOccurrence;
    }

    public int longestConsecutiveMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxOcc = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                int left = map.getOrDefault(i - 1, 0);
                int right = map.getOrDefault(i + 1, 0);
                int sum = left + right + 1;
                maxOcc = Math.max(maxOcc, sum);
                map.put(i, sum);

                map.put(i - left, sum);
                map.put(i + right, sum);
            }

        }
        return maxOcc;
    }

    /***
     *
     */
}

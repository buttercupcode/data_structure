package questions.medium;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        int indexDiff = 3, valueDiff = 0;
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        boolean b = containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(arr, indexDiff, valueDiff);
        System.out.println(b);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff < 0 || valueDiff < 0)
            return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) valueDiff + 1);
            if (map.containsKey(bucket)
                    || map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= 1
                    || map.containsKey(bucket + 1) && remappedNum - map.get(bucket + 1) <= 1)
                return true;
            if (map.entrySet().size() >= indexDiff) {
                long lastBucket = ((long) nums[i - indexDiff] - Integer.MIN_VALUE) / ((long) valueDiff + 1);
                map.remove((lastBucket));
            }
            map.put(bucket, remappedNum);

        }
        return false;
    }
}

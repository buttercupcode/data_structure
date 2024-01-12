package questions;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        ContainsNearbyDuplicate cnd = new ContainsNearbyDuplicate();
        int[] nums= new int[]{1,2,3,1,2,3};//{1,2,3,1};
        boolean b = cnd.containsNearbyDuplicate(nums, 2);
        System.out.println(b);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

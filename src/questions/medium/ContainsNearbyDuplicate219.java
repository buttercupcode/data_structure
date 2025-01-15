package questions.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicate219 {
    public static void main(String[] args) {
        ContainsNearbyDuplicate219 cnd = new ContainsNearbyDuplicate219();
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};//{1,2,3,1};
        //boolean b = cnd.containsNearbyDuplicateMySol(nums, 2);
        boolean b = cnd.containsNearByBetterSol(nums, 2);
        System.out.println(b);
    }

    public boolean containsNearbyDuplicateMySol(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearByBetterSol(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i - k - 1) >= 0)
                set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> field = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = field.put(nums[i], i);
            if (j != null && (i - j) <= k)
                return true;
        }
        return false;
    }

}

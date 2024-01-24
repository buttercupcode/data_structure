package questions.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(cd.containsDuplicate(arr));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}

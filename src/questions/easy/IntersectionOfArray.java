package questions.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArray {
    public static void main(String[] args) {
        IntersectionOfArray i = new IntersectionOfArray();
        int[] intersection = i.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i))
                intersect.add(i);
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}

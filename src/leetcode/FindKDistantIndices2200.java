package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKDistantIndices2200 {
    public static void main(String[] args) {

    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0, a = 0; i < nums.length; i++) {
            if (nums[i] == key) {

                for (a = Math.max(a, i - k); a <= Math.min(nums.length - 1, i + k); a++) {
                    output.add(a);
                }

            }
        }
        return output;
    }
}

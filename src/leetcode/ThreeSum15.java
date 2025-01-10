package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        //List<List<Integer>> lists = threeSum15.threeSum(new int[]{1, -1, -1, 0});
        List<List<Integer>> lists = threeSum15.threeSum(new int[]{-2, 0, 1, 1, 2});

        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i + 1, high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[low]);
                    res.add(nums[high]);
                    output.add(res);
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else if (sum > 0) {
                    high--;
                }

            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;

        }
        return output;
    }
}



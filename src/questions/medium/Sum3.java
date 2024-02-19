package questions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        Sum3 sum = new Sum3();
        //List<List<Integer>> lists = sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        //List<List<Integer>> lists = sum.threeSum(new int[]{0,0,0,0});
        //List<List<Integer>> lists = sum.threeSum(new int[]{1,-1,-1,0});
        List<List<Integer>> lists = sum.threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> elements = List.of(nums[i], nums[low], nums[high]);
                    res.add(elements);

                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                    high--;
                    low++;
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }

        }
        return res;

    }
}

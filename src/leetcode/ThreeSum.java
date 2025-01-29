package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        List<List<Integer>> l = s.threeSum(new int[]{0,1,1});
        System.out.println(l);

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
         int i =0;
        while (i < n - 2) {

            int begin = i+1, end = n - 1;
            while (begin < end && begin < n - 1 && end > i) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[begin]);
                    l.add(nums[end]);
                    res.add(l);
                    begin++;
                    end--;
                    while (nums[end] == nums[end + 1]) {
                        end--;
                    }
                    while (nums[begin] == nums[begin - 1]) {
                        begin++;
                    }


                } else if (sum > 0) {
                    do {
                        end-=1;
                    } while (begin< end && nums[end] == nums[end + 1]);
                } else {
                    do{
                        begin+=1;
                    }
                    while (begin< end && nums[begin] == nums[begin - 1]);
                }

            }
            do {
                i++;
            } while (nums[i] == nums[i - 1]);

        }
        return res;
    }
}

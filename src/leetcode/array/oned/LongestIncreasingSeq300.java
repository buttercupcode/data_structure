package leetcode.array.oned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSeq300 {
    public static void main(String[] args) {
        LongestIncreasingSeq300 l = new LongestIncreasingSeq300();
        int i = l.lengthOfLIS(new int[]
                {10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i : dp) {
            ans = Math.max(i, ans);
        }

        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int c = nums[i];
            if (c > seq.getLast())
                seq.add(c);
            else {
                int j = binarysearch(seq, c);
               /* int j = 0;
                while( c > seq.get(j)){
                    j++;
                }*/
                seq.set(j, c);
            }
        }
        return seq.size();
    }

    public int binarysearch(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (list.get(mid) == num)
                return mid;
            else if (list.get(mid) < num)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

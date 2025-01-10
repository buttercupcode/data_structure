package leetcode;

import static java.lang.Math.min;

public class RemoveDuplicate80 {
    public static void main(String[] args) {
        RemoveDuplicate80 removeDuplicate80 = new RemoveDuplicate80();
        int k = removeDuplicate80.removeDuplicates(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            int count = 1;
            while (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                r++;
                count++;
            }
            int min = min(2, count);
            for (int i = 0; i < min; i++) {
                nums[l] = nums[r];
                l++;
            }
            r++;

        }
        return l;
    }
}

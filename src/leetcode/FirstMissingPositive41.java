package leetcode;

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        FirstMissingPositive41 fm = new FirstMissingPositive41();
        //System.out.println(fm.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(fm.firstMissingPositive(new int[]{3,4,-1,1}));
        //System.out.println(fm.firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                contains1 = true;
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }
        if (!contains1) return 1;
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[value] = -Math.abs(nums[value]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) {
            return n;
        }
        return n + 1;
    }
}

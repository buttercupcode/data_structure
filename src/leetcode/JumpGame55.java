package leetcode;

public class JumpGame55 {
    public static void main(String[] args) {
        JumpGame55 jumpGame55 = new JumpGame55();
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean t = jumpGame55.canJump(nums);
        System.out.println(t);
    }

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farthest < i)
                return false;
            farthest = Math.max(farthest, i + nums[i]);

        }
        return true;
    }
}

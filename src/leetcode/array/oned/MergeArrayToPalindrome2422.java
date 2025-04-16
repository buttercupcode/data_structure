package leetcode.array.oned;

public class MergeArrayToPalindrome2422 {
    public static void main(String[] args) {
        MergeArrayToPalindrome2422 m = new MergeArrayToPalindrome2422();

        System.out.println(m.minimumOperations(new int[]{4, 3, 2, 1, 2, 3, 1}));
    }

    public int minimumOperations(int[] nums) {
        int count = 0, left = nums[0], right = nums[nums.length - 1], i = 0, j = nums.length - 1;
        while (i < j) {
            if (left == right) {
                i++;
                j--;
                left = nums[i];
                right = nums[j];
            } else if (left < right) {
                i++;
                left += nums[i];
                count++;
            } else {
                j--;
                right += nums[j];
                count++;
            }
        }
        return count;
    }
}

package leetcode;

public class RemoveDuplicate26 {
    public static void main(String[] args) {
        RemoveDuplicate26 removeDuplicate26 = new RemoveDuplicate26();
        int k = removeDuplicate26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] != nums[i]) {
                nums[idx + 1] = nums[i];
                idx++;
            }
        }
        return idx + 1;
    }
}

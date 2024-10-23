package linkedlist.medium;

public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        int duplicate = fd.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int slow2 = 0;
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }

}

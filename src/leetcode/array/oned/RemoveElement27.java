package leetcode.array.oned;

import static java.util.Arrays.sort;

public class RemoveElement27 {
    public static void main(String[] args) {
        RemoveElement27 removeElement27 = new RemoveElement27();
        int[] nums = new int[]{3, 2, 2, 3}; // Input array
        int val = 3; // Value to remove
        int[] expectedNums = new int[]{2, 2}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement27.removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i);
        }
        System.out.println();
        nums = new int[]{2};
        val = 3;
        expectedNums = new int[]{2};
        k = removeElement27.removeElement(nums, val);
        sort(nums, 0, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i);
        }

        k = removeElement27.removeElements(new int[]{3, 2, 2, 3}, 3);
        System.out.println(k);
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeElements(int[] nums, int val) {

        int i = 0, j = nums.length - 1;
        while (i < j) {

            if (nums[i] == val) {
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
                j--;
            } else {
                i++;
            }
        }
        return j + 1;
    }

}

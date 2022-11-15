package array;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(b.findPeek(new int[]{1, 2, 1, 3, 5, 6, 4}/*{1,2,3,1})*/));
        System.out.println(Arrays.toString(b.searchRangeLeetCode(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;

    }

    /**
     * this based on first template of binary search where left and right are both +1 or -1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    /**
     * this based on second template of binary search where left or right are either +1 or -1
     *
     * @param nums
     * @return
     */
    public int findPeek(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1])
                high = mid;
            else if (nums[mid] < nums[mid + 1])
                low = mid + 1;
        }
        return low;
    }

    public int[] searchRangeLeetCode(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(nums, target + 1) - 1};
    }
}

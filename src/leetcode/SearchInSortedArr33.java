package leetcode;

public class SearchInSortedArr33 {
    public static void main(String[] args) {
        SearchInSortedArr33 s = new SearchInSortedArr33();
        int out = s.searchInSortedArr(new int[]{1}, 1);
        System.out.println(out);
    }

    public int searchInSortedArr(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = (high + low) / 2;

        while (low <= high) {
            mid = (high + low) / 2;
            int comp;
            if ((target >= nums[0] && nums[mid] >= nums[0])
                    || (target < nums[0] && nums[mid] < nums[0])) {
                comp = nums[mid];
            } else {
                if (target < nums[0])
                    comp = Integer.MIN_VALUE;
                else
                    comp = Integer.MAX_VALUE;
            }
            if (target == comp) return mid;
            else if (target > comp)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}

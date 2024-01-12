package questions;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSumII two = new TwoSumII();
        //int[] ints = two.twoSumTwoPointer(arr, target);
        int[] ints = two.twoSumBinary(arr, target);
        System.out.println(ints);
    }

    public int[] twoSumTwoPointer(int[] arr, int target) {

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target)
                return new int[]{l + 1, r + 1};
            if (sum < target)
                l++;
            else
                r--;
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumBinary(int[] arr, int target) {

        for (int i = 0; i < arr.length - 1; i++) {
            int low = i + 1, high = arr.length - 1;
            int tmp = target - arr[i];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (tmp == arr[mid])
                    return new int[]{i + 1, mid + 1};
                else if (arr[mid] > tmp)
                    high = mid;
                else
                    low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}

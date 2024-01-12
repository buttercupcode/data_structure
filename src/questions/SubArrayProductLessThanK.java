package questions;

public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        SubArrayProductLessThanK var = new SubArrayProductLessThanK();
        int v = var.numSubarrayProductLessThanK(nums, k);
        System.out.println(v);
    }

    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int i = 0, j = 0;
        int count = 0;
        int product = 1;
        while (i <= j && j < arr.length) {
            product *= arr[j];
            while (product >= k && i <= j) {
                product = product / arr[i];
                i++;
            }
            count += j + 1 - i;
            j++;
        }
        return count;
    }
}

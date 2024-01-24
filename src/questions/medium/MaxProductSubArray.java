package questions.medium;


public class MaxProductSubArray {
    public static void main(String[] args) {
        MaxProductSubArray m = new MaxProductSubArray();
        int i = m.maxProduct(new int[]{-2, 3, -4});//{2, 3, -2, 4});
        System.out.println(i);
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        for (int i = 1, min = res, max = res; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            min = Math.min(nums[i], nums[i] * min);
            max = Math.max(nums[i], nums[i] * max);
            res = Math.max(max, res);
        }
        return res;
    }

}

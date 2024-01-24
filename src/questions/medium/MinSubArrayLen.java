package questions.medium;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen min = new MinSubArrayLen();
        int[] arr = new int[]{1, 4, 4};//{2, 3, 1, 2, 4, 3};
        int target = 4;//7;
        int output = min.minSubArrayLen(target, arr);
        System.out.println(output);

    }

    public int minSubArrayLen(int target, int[] nums) {
        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                len = Math.min(len, end - begin + 1);

                sum -= nums[begin++];

            }
            end++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}

package questions.medium;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray max = new MaxSubArray();
        int maxNum = max.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(maxNum);
    }

    public int maxSubArray(int[] arr) {
        int max = 0, maxTillNow = 0;
        for (int j : arr) {
            maxTillNow = Math.max(maxTillNow + j, j);
            max = Math.max(max, maxTillNow);
        }
        return max;
    }
}

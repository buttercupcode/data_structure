package leetcode;

public class MaxProfit121 {
    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        int out = 0;
        MaxProfit121 mp = new MaxProfit121();
        out = mp.maxProfit(input);
        System.out.println(out);
        input = new int[]{7, 6, 4, 3, 1};
        out = mp.maxProfit(input);
        System.out.println(out);
    }

    public int maxProfit(int[] prices) {
        int diff = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            diff = Math.max(diff, prices[i] - minValue);

        }
        return diff;
    }
}

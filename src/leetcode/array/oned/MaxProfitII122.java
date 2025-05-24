package leetcode.array.oned;

public class MaxProfitII122 {
    public static void main(String[] args) {
        MaxProfitII122 maxProfitII122 = new MaxProfitII122();
        int i = maxProfitII122.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
        i = maxProfitII122.maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }


    public int maxProfit2(int[] prices) {
        int i = 0;
        int n = prices.length;
        int valley = prices[0];
        int peak = prices[0];
        int profit = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (prices[i] >= prices[i + 1]))
                i++;
            valley = prices[i];
            while ((i < n - 1) && (prices[i] <= prices[i + 1]))
                i++;
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
}

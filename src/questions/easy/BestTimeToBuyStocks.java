package questions.easy;

public class BestTimeToBuyStocks {
    public static void main(String[] args) {
        BestTimeToBuyStocks bm = new BestTimeToBuyStocks();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = bm.maxProfit(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int lowestValue = Integer.MAX_VALUE;
        int overallProfit = 0, todayProfit = 0;
        for (int price : prices) {
            if (price < lowestValue)
                lowestValue = price;
            todayProfit = price - lowestValue;
            if (todayProfit > overallProfit)
                overallProfit = todayProfit;
        }
        return overallProfit;
    }
}

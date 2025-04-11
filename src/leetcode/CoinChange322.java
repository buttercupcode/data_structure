package leetcode;

public class CoinChange322 {
    Integer[] memo;
    public static void main(String[] args) {
        CoinChange322 c = new CoinChange322();
        int i = c.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        memo= new Integer[amount+1];
        return recursionHelper(coins,amount);
    }

    public int recursionHelper(int[] coins, int remain){
        if(remain<0)
            return -1;
        if(remain==0)
            return 0;
        if(memo[remain]!=null)
            return memo[remain];
        int minCount = Integer.MAX_VALUE;
        for(int coin: coins){
            int count = recursionHelper(coins,remain-coin);
            if(count==-1)
                continue;
            minCount= Math.min(minCount,count+1);
        }
        memo[remain]= minCount==Integer.MAX_VALUE?-1:minCount;
        return memo[remain];
    }
}

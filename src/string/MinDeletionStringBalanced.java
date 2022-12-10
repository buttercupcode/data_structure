package string;

public class MinDeletionStringBalanced {
    public static void main(String[] args) {

    }

    public int makeStringBetter(String s) {

        int[] dp = new int[s.length() + 1];
        int bCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                dp[i + 1] = Math.min(dp[i + 1], bCount);
            } else {
                dp[i + 1] = dp[i];
                bCount++;
            }
        }
        return dp[s.length()];
    }
}

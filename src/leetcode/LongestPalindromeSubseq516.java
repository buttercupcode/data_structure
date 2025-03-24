package leetcode;

public class LongestPalindromeSubseq516 {
    public static void main(String[] args) {
        LongestPalindromeSubseq516 l = new LongestPalindromeSubseq516();
        System.out.println(l.longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    public int helper(String s, int l, int r, Integer[][] memo) {
        if (memo[l][r] != null)
            return memo[l][r];

        if (l > r || l >= s.length())
            return 0;
        if (l == r)
            return 1;
        if (s.charAt(l) == s.charAt(r)) {
            memo[l][r] = 2 + helper(s, l + 1, r - 1, memo);
        } else {
            memo[l][r] = Math.max(helper(s, l + 1, r, memo), helper(s, l, r - 1, memo));

        }
        return memo[l][r];
    }
}

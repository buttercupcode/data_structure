package leetcode;

public class PalindromeSubstring647 {
    public static void main(String[] args) {
        PalindromeSubstring647 p = new PalindromeSubstring647();
        int count = p.countSubstrings("abc");
        System.out.println(count);
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i, i + 1);
            count += helper(s, i, i);
        }
        return count;

    }

    public int helper(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}

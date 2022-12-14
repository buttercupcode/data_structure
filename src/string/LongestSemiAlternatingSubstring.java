package string;

public class LongestSemiAlternatingSubstring {
    public static void main(String[] args) {
        LongestSemiAlternatingSubstring lsa = new LongestSemiAlternatingSubstring();
        System.out.println(lsa.longestSemiAlternatingSubString("baaabbabbb"));
    }

    public int longestSemiAlternatingSubString(String s) {
        int max = 0;
        int base = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && (s.charAt(i) == s.charAt(i - 2))) {
                max = Math.max(max, i - base);
                base = i - 1;
            }
        }
        return max;
    }
}

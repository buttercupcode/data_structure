package string;

public class LongestSubNoThreeLetSame {


    public static void main(String[] args) {
        LongestSubNoThreeLetSame lsm = new LongestSubNoThreeLetSame();
        System.out.println(lsm.subString("baaabbabbb"));
    }

    public String subString(String s) {
        int[] counts = new int[s.length() + 1];
        char[] chars = s.toCharArray();
        int i = 0, j = 1;
        String maxString = "";
        while (i < s.length() && j < s.length()) {
            char ch2 = chars[j];
            char ch1 = chars[j - 1];
            if (ch1 == ch2) {
                counts[j] = counts[j - 1] + 1;
                if (counts[j] >= 2) {
                    int len = j - i - 1;
                    maxString = maxString.length() >= len ? maxString : s.substring(i, j);
                    i = j - counts[j] + 1;
                }
            }
            j++;
        }
        return maxString;
    }
}

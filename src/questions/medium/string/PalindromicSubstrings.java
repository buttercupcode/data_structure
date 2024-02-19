package questions.medium.string;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        int s = ps.countSubstrings("aaa");
        System.out.println(s);
    }

    public int countSubstrings(String s) {
        int count = 0;
        if (s.length() < 2)
            return s.length();
        for (int i = 0; i < s.length(); i++) {

            int low = i, high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;
            }


            low = i;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;
            }

        }
        return count;
    }
}

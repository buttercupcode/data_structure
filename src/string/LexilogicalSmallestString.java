package string;

public class LexilogicalSmallestString {

    public static void main(String[] args) {
        LexilogicalSmallestString lsm = new LexilogicalSmallestString();
        System.out.println(lsm.minString("abcda"));
    }

    public String minString(String s) {
        StringBuffer sb = new StringBuffer(s);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return (sb.deleteCharAt(i)).toString();
            }
        }
        return s;
    }
}

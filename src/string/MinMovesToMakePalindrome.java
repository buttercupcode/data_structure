package string;

public class MinMovesToMakePalindrome {
    public static void main(String[] args) {
        MinMovesToMakePalindrome m = new MinMovesToMakePalindrome();
        System.out.println(m.minMovesToMakePalindrome("roggbxxpbpro"));

    }

    public int minMovesToMakePalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (sb.length() > 2) {
            char ch1 = sb.charAt(0);
            char ch2 = sb.charAt(sb.length() - 1);
            int len = sb.length();
            if (ch1 == ch2) {
                sb.deleteCharAt(len - 1);
                sb.deleteCharAt(0);
            } else {
                int index1 = sb.lastIndexOf(Character.toString(ch1));
                int index2 = sb.indexOf(Character.toString(ch2));
                int step1 = len - 1 - index1;
                int step2 = index2;
                if (step1 <= step2) {
                    count += step1;
                    sb.deleteCharAt(index1);
                    sb.deleteCharAt(0);
                } else {
                    count += step2;
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(index2);
                }
            }

        }
        return count;
    }
}


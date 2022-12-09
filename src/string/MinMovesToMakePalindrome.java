package string;

public class MinMovesToMakePalindrome {
    public static void main(String[] args) {
        MinMovesToMakePalindrome m = new MinMovesToMakePalindrome();
        System.out.println(m.minMovesToMakePalindrome("letelt"));

    }

    public int minMovesToMakePalindrome(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 2) {
            char ch1 = sb.charAt(0);
            int len = sb.length();
            char ch2 = sb.charAt(len - 1);

            if (ch1 == ch2) {
                sb.deleteCharAt(len - 1);
                sb.deleteCharAt(0);
            } else {
                int id1 = sb.lastIndexOf(Character.toString(ch1));
                int id2 = sb.indexOf(Character.toString(ch2));

                int steps1 = len - id1 - 1;
                int steps2 = id2;

                if (steps1 > steps2) { // keep last char, move char at id2
                    count += steps2;
                    sb.deleteCharAt(id2);
                    sb.deleteCharAt(sb.length() - 1);
                } else {// keep first char, move char at id1
                    count += steps1;
                    sb.deleteCharAt(id1);
                    sb.deleteCharAt(0);
                }

            }
        }

        return count;
    }
}


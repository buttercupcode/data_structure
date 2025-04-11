package leetcode.numbers;

public class StringToInteger8 {
    public static void main(String[] args) {
        StringToInteger8 s = new StringToInteger8();
        // System.out.println(s.myAtoi("42"));
        //System.out.println(s.myAtoi("-042"));
        //System.out.println(s.myAtoi("1337c0d3"));
        //System.out.println(s.myAtoi("0-1"));
        System.out.println(s.myAtoi("words and 987"));
    }

    public int myAtoi(String s) {
        char[] ch = s.toCharArray();
        int out = 0;
        boolean negative = false, digitRead = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(ch[i])) {
                out = out * 10 + (ch[i] - '0');
                digitRead = true;
                continue;
            }
            if (digitRead)
                break;
            if (ch[i] == ' ')
                continue;
            if (ch[i] == '-')
                negative = true;
            if (Character.isLetter(ch[i]))
                break;
        }
        if (negative) {
            out *= -1;
        }
        if (negative && out < Integer.MIN_VALUE / 10)
            return Integer.MIN_VALUE;
        if (out >= Integer.MAX_VALUE / 10)
            return Integer.MAX_VALUE;

        return out;
    }
}


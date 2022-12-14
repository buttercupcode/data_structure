package string;

public class StringWithout3Identical {
    public static void main(String[] args) {
        StringWithout3Identical sb = new StringWithout3Identical();
        System.out.println(sb.getString("xxxtxxx"));
    }

    public String getString(String s) {
        StringBuffer sb = new StringBuffer();
        if (s.length() <= 2)
            return s;
        sb.append(s, 0, 2);
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) || s.charAt(i) != s.charAt(i - 2))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

package leetcode;

public class ValidPalindorme125 {
    public static void main(String[] args) {
        ValidPalindorme125 v = new ValidPalindorme125();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        s = s.toLowerCase();
        while (begin <= end) {
            if (!Character.isLetterOrDigit(s.charAt(begin)))
                begin++;
            else if (!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            else {
                if (s.charAt(begin) != s.charAt(end))
                    return false;
                begin++;
                end--;
            }
        }
        return true;
    }
}

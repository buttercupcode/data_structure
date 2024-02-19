package questions.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        //boolean valid = vp.isPalindrome("A man, a plan, a canal: Panama");
        boolean valid = vp.isPalindrome("");
        System.out.println(valid);
    }

    public boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

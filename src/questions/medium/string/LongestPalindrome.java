package questions.medium.string;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String babad = lp.longestPalindrome("babad");
        System.out.println(babad);

    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2)
            return s;
        String maxStr= s.substring(0,1);
        for(int i = 0; i<len-1; i++){
            String odd = extendPalindrome(s,i,i);
            String even = extendPalindrome(s,i,i+1);
            maxStr = (odd.length() > even.length()) ? ((odd.length() > maxStr.length()) ? odd : maxStr) : ((even.length() > maxStr.length()) ? even : maxStr);
        }
        return maxStr;
    }

    private String extendPalindrome(String s, int low, int high) {
        while(low>=0
                && high<s.length()
                && s.charAt(low)==s.charAt(high)){
            low--;
            high++;
        }
        return s.substring(low+1,high);
    }


}

package leetcode;

public class ValidAnagram242 {
    public static void main(String[] args) {
        ValidAnagram242 v = new ValidAnagram242();
        boolean b = false;
        //b= v.isAnagram("anagram","nagaram");
        b = v.isAnagram("rat", "car");
        System.out.println(b);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] original = new int[26];

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            original[sc[i] - 'a']++;
            original[tc[i] - 'a']--;
        }
        for (int i : original) {
            if (i != 0)
                return false;
        }
        return true;
    }
}

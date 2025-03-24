package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutationInString567 {
    public static void main(String[] args) {
        PermutationInString567 p = new PermutationInString567();
        System.out.println(p.checkInclusion("adc", "dcda"));

    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Set<Character> set = new HashSet<>();
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        for (char ch : ch1) {
            set.add(ch);
        }
        char[] ch2 = s2.toCharArray();
        for (int i = 0; i < ch2.length - s1.length() + 1; i++) {
            if (set.contains(ch2[i])) {
                if (helper(ch1, s2, i))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[] s1, String s2, int start) {
        String s = s2.substring(start, start + s1.length);
        char[] ch2 = s.toCharArray();
        Arrays.sort(ch2);
        for (int i = 0; i < s1.length; i++) {
            if (ch2[i] != s1[i])
                return false;
        }

        return true;
    }
}

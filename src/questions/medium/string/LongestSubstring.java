package questions.medium.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        // System.out.println(ls.lengthOfLongestSubstringMap("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstringSet("abcabcbb"));
    }

    public int lengthOfLongestSubstringMap(String s) {
        Map<Character, Integer> keys = new HashMap<>();
        char[] seq = s.toCharArray();
        int i = 0, j = 0, max = 0;

        while (j < s.length()) {
            if (keys.containsKey(seq[j])) {
                i = Math.max(i, keys.get(seq[j]) + 1);

            }
            keys.put(seq[j], j);
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }

    public int lengthOfLongestSubstringSet(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        int max = 0;
        while (j < chars.length) {
            while (set.contains(chars[j])) {
                set.remove(chars[i]);
                i++;
            }
            max = Math.max(max, j - i + 1);
            set.add(chars[j++]);
        }
        return max;
    }
}

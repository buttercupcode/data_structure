package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringWithoutRepeat {

    public static void main(String[] args) {
        LongestStringWithoutRepeat withoutRepeat = new LongestStringWithoutRepeat();
        // System.out.println(withoutRepeat.execute("pwwkew"/*"bbbbb","abcabcbb"*/));
        System.out.println(withoutRepeat.lengthOfLongestSubstring("pwwkew"));
    }

    public int execute(String s) {
        int left = 0, right = 0;
        int max = 0;
        char[] ch = s.toCharArray();
        Set<Character> elements = new HashSet<>();
        while (right < s.length()) {
            while (elements.contains(ch[right])) {
                elements.remove(ch[left]);
                left++;
            }
            elements.add(ch[right]);
            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

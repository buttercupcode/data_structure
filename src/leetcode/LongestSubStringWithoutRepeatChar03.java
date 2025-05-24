package leetcode;

import java.util.Arrays;

public class LongestSubStringWithoutRepeatChar03 {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatChar03 l = new LongestSubStringWithoutRepeatChar03();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right, max = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        for (right = 0; right < s.length(); right++) {
            if (map[s.charAt(right)] >= left)
                left = map[s.charAt(right)] + 1;
            map[s.charAt(right)] = right;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

package leetcode.array.oned.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring26 {
    public static void main(String[] args) {
        MinimumWindowSubstring26 m = new MinimumWindowSubstring26();
        String s = m.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
        //s=m.minWindowMain("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minWindowMain(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<
                Character,
                Integer
                >();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (
                    dictT.containsKey(c) &&
                            windowCounts.get(c).intValue() == dictT.get(c).intValue()
            ) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (
                        dictT.containsKey(c) &&
                                windowCounts.get(c).intValue() < dictT.get(c).intValue()
                ) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty())
            return "";
        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        int begin = 0, end = 0;
        // Number of unique characters in t, which need to be present in the desired window.
        int required = tCount.size();
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();
        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};
        while (end < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(end);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);


            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (tCount.containsKey(c) && windowCounts.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }
            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (begin <= end && formed == required) {
                c = s.charAt(begin);
                // Save the smallest window until now.
                if (ans[0] == -1 || end - begin + 1 < ans[0]) {
                    ans[0] = end - begin + 1;
                    ans[1] = begin;
                    ans[2] = end;
                }
// The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tCount.containsKey(c) && windowCounts.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }
                // Move the left pointer ahead, this would help to look for a new window.
                begin++;
            }
            // Keep expanding the window once we are done contracting.
            end++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

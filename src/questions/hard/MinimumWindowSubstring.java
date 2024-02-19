package questions.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = m.minString2("ADOBECODEBANC", "ABC");
        String s1 = m.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minString2(String s, String t) {
        if (s == null || s.length() < t.length() || s.isEmpty())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, count = 0, minLeft = 0, minLength = s.length() + 1;
        char[] chars = s.toCharArray();
        while (right < s.length()) {

            if (map.containsKey(chars[right])) {
                map.put(chars[right], map.get(chars[right]) - 1);
                if (map.get(chars[right]) >= 0)
                    count++;
                while (count == t.length()) {
                    if (right - left + 1 < minLength) {
                        minLeft = left;
                        minLength = right - left + 1;
                    }
                    if (map.containsKey(chars[left])) {
                        map.put(chars[left], map.get(chars[left]) + 1);
                        if (map.get(chars[left]) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        if (minLength > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLength);
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.isEmpty()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
   /*
    public String minWindow(String s, String t) {

    if(s==null|| t==null||s.isEmpty()||t.isEmpty()|| s.length()<t.length())
        return "";
    int[] map = new int[128];
    for(char c : t.toCharArray())
        map[c-'A']++;
    int left=0,right=0,minLen=s.length()+1, startIndex=0;
    int count=0;
        char[] chS = s.toCharArray();
    while(right<chS.length){
        if(map[chS[right++]]-- >0)
            count--;
        while(count==0){
            if(right-left<minLen){
                startIndex=left;
                minLen=right-left;
            }
            if(map[chS[left++]]++==0){
                count++;
            }
        }

    }
    return minLen== s.length()+1?"":new String(chS,startIndex,minLen);
    }
*/
}

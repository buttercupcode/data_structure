package questions.medium.string;
//TODO yet to imple

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length())
            return longestCommonSubsequence(text2, text1);

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < text2.length(); i++) {
            List<Integer> list = map.getOrDefault(text2.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(text2.charAt(i), list);
        }
        int count = 0, j = 0;
        for (int i = 0; i < text1.length(); i++) {
            if (map.containsKey(text1.charAt(i))) {
                ////
            }
        }
        return 0;
    }
}

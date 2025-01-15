package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {

    public static void main(String[] args) {
        IsomorphicStrings205 iso = new IsomorphicStrings205();
        boolean value = iso.isIsomorphic("paper", "title");
        System.out.println(value);
    }

    public boolean isIsomorphic(String s, String t) {

        if (t.length() != s.length())
            return false;
        Map<Character, Character> dictKey = new HashMap<>();
        Map<Character, Character> dictValue = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if (!dictKey.containsKey(sc) && !dictValue.containsKey(tc)) {
                dictKey.put(sc, tc);
                dictValue.put(tc, sc);
            } else if (dictKey.get(sc) != tc || dictValue.get(tc) != sc)
                return false;
        }
        return true;
    }
}

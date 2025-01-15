package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern290 {
    public static void main(String[] args) {
        WordPattern290 wp = new WordPattern290();
        boolean b = wp.wordPattern("a", "a");
        System.out.println(b);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length)
            return false;
        Map<String, Integer> index = new HashMap<>();
        for (Integer i = 0; i < arr.length; i++) {
            if (!Objects.equals(index.put(Character.toString(pattern.charAt(i)), i), index.put(arr[i], i)))
                return false;
        }
        return true;

    }
}

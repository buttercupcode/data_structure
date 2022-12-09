package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthConcatenatedStringUniqueChar {
    private int result = 0;

    public static void main(String[] args) {
        MaxLengthConcatenatedStringUniqueChar m = new MaxLengthConcatenatedStringUniqueChar();
        System.out.println(m.maxLength(List.of("a", "abc", "d", "de", "def")));
    }

    public int maxLengthOwn(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;

        String[] strings = arr.toArray(new String[0]);
        int max = 0;
        String maxString = "";
        for (int i = 0; i < strings.length; i++) {
            maxString = strings[i];
            if (eachCharUnique(maxString, "")) {
                max = Math.max(max, maxString.length());
                for (int j = i + 1; j < strings.length; j++) {
                    if (eachCharUnique(maxString, strings[j])) {
                        maxString = maxString + strings[j];
                        max = Math.max(max, maxString.length());
                    }
                }
            }
        }
        return max;
    }

    private boolean eachCharUnique(String string1, String string2) {
        Set<Character> set = new HashSet<>();
        char[] chars = (string1 + string2).toCharArray();
        for (char c : chars) {
            if (set.contains(c))
                return false;
            set.add(c);
        }
        return true;
    }

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        dfs(arr, "", 0);

        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }

        if (idx == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}

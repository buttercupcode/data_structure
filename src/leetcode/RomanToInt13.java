package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt13 {
    public static void main(String[] args) {
        RomanToInt13 r = new RomanToInt13();
        int output = r.romanToInt("MCMXCIV");
        System.out.println(output);
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = s.length();
        int ans = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && map.get(ch[i]) < map.get(ch[i + 1]))
                ans -= map.get(ch[i]);
            else
                ans += map.get(ch[i]);
        }
        return ans;
    }
}

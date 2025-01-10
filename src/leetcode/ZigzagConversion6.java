package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion6 {
    public static void main(String[] args) {
        ZigzagConversion6 zigzagConversion6 = new ZigzagConversion6();
        String output = zigzagConversion6.convert("AB", 1);
        System.out.println(output);

    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<List<Character>> lists = new ArrayList<>();
        int d = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            List<Character> list = new ArrayList<>();
            lists.add(list);
        }
        int index = 0;
        for (char aChar : chars) {
            lists.get(index).add(aChar);
            if (index == 0) {
                d = 1;
            } else if (index == numRows - 1) {
                d = -1;
            }
            index += d;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (char c : lists.get(i)) {
                out.append(c);
            }
        }
        return out.toString();
    }
}

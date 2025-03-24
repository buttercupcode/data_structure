package leetcode;

import java.util.*;

public class LetterPhoneNumCombination17 {
    static Map<Character, List<String>> map = new HashMap<>();

    static {
        map.put('1', List.of());
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        LetterPhoneNumCombination17 l = new LetterPhoneNumCombination17();
        //List<String> strings = l.letterCombinations("23");
        //System.out.println(strings);
        List<String> strings1 = l.letterCombinations1("23");
        System.out.println(strings1);
    }

    public List<String> letterCombinations1(String digits) {
        if (digits.isEmpty())
            return List.of();
        List<String> arrList = List.of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        LinkedList<String> queue = new LinkedList<>();

        queue.add("");


        for (char c : digits.toCharArray()) {

            String s = arrList.get(Character.getNumericValue(c));
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                String peek = queue.remove();
                for (char ch : s.toCharArray()) {
                    queue.add(peek + ch);
                }
            }

        }
        return queue;

    }

    public List<String> letterCombinations(String digits) {
        char[] ch = digits.toCharArray();
        Set<String> set = new HashSet<>();
        for (char c : ch) {
            helper(set, map.get(c));
        }
        return new ArrayList<>(set);
    }

    public void helper(Set<String> oldStrings, List<String> newString) {
        if (oldStrings.isEmpty()) {
            oldStrings.addAll(newString);
        } else {
            List<String> toAdd = new ArrayList<>();
            Set<String> toRemove = new HashSet<>();
            for (String old : oldStrings) {

                for (String string : newString) {
                    String s = old + string;
                    toAdd.add(s);

                }
                toRemove.add(old);

            }
            oldStrings.removeAll(toRemove);
            oldStrings.addAll(toAdd);
//            for (String rm : toRemove) {
//                oldStrings.remove(rm);
//            }
        }

    }
}

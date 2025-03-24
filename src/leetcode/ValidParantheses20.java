package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses20 {
    public static void main(String[] args) {
        ValidParantheses20 vp = new ValidParantheses20();
        System.out.println(vp.isValid("()"));

    }

    public boolean isValid(String s) {
        Map<Character, Character> kv = new HashMap<>();
        kv.put(')', '(');
        kv.put('{', '}');
        kv.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            Character val = kv.get(ch);
            if (val == null) {
                stack.push(ch);
            } else {
                //char s1 = ;
                if (stack.isEmpty() || !val.equals(stack.pop()))
                    return false;

            }
        }
        return stack.isEmpty();
    }
}


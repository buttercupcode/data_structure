package questions.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("(]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put('}', '{');
        pairs.put(')', '(');
        pairs.put(']', '[');

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);

            if (pairs.containsKey(c)) {
                if(stack.isEmpty())
                    return false;
                char e = stack.pop();
                if (pairs.getOrDefault(c, '0') != e)
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}

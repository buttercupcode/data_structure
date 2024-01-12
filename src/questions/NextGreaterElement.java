package questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }

    public int[] next(int[] num1, int[] num2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : num2) {
            while (!stack.isEmpty() || stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < num1.length; i++) {
            num1[i] = map.getOrDefault(num1[i], -1);
        }
        return num1;
    }
}

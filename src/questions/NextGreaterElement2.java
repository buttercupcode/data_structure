package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 1};
        NextGreaterElement2 ne = new NextGreaterElement2();
        int[] next = ne.next(elements);
        System.out.println(next);

    }

    public int[] next(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) stack.push(i);
        }
        return result;
    }
}

package questions.medium;

import java.util.Stack;

public class DailyTemp {
    public static void main(String[] args) {
        DailyTemp dt = new DailyTemp();
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dt.dailyTemperatures(temp);
        for (int j : ints) {
            System.out.println(j);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] nexVal = new int[temperatures.length];
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temp) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nexVal[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return nexVal;
    }
}

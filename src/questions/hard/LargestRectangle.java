package questions.hard;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();
        lr.largestRectangleArea(new int[]{2, 2, 2});
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Param> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() || stack.peek().height > heights[i]) {
                Param p = stack.pop();
                area = Math.max(area, p.height * (i - p.index));
            }
            stack.push(new Param(heights[i], i));
        }
        while (!stack.isEmpty()) {
            Param p = stack.pop();
            area = Math.max(area, p.height * p.index);
        }

        return area;
    }

    static class Param {

        int index;
        int height;

        Param(int index, int height) {
            this.height = height;
            this.index = index;
        }

    }
}

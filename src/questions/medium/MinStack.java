package questions.medium;

import java.util.Stack;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {

    }

    public MinStack() {

    }

    public void push(int val) {
        if(val<=min) {
            stack.push(min);
            min=val;
        }
       stack.push(val);
    }

    public void pop() {
        if(min== stack.pop())
            min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


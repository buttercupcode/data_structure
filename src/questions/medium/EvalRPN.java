package questions.medium;

import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args) {
    EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
           int result;
            if(s.equals("+"))
                result= stack.pop()+stack.pop();
            else if(s.equals("-")) {
                 int a= stack.pop();
                 int b = stack.pop();
                 result = b-a;
            }
            else if(s.equals("*"))
                result= stack.pop()*stack.pop();
            else if(s.equals("/")) {
                int a = stack.pop();
                int b= stack.pop();
                result = b / a;
            }
            else {
                result = Integer.parseInt(s);
            }
            stack.push(result);
        }
        return stack.pop();
    }

    }

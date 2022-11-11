package string;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
   /*   List<String> output=  p.generateParenthesis(2);
      for(String s: output)
          System.out.println(s);*/
        List<String> output2=  p.generateParenthesisBackTrack(2);
        for(String s: output2)
            System.out.println(s);
    }

        public List<String> generateParenthesis(int n) {

            List<String> combinations = new ArrayList();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current))
                    result.add(new String(current));
            } else {
                current[pos] = '(';
                generateAll(current, pos+1, result);
                current[pos] = ')';
                generateAll(current, pos+1, result);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c: current) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return (balance == 0);
        }

    public List<String> generateParenthesisBackTrack(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    }


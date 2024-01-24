package questions.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] input = new char[][]
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        boolean output = vs.isValidSudoku(input);
        System.out.println(output);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String input = "(" + board[i][j] + ")";

                    if (!set.add(input + i) || !set.add(j + input) || !set.add(i / 3 + input + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

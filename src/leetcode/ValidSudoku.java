package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        boolean b = vs.isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        System.out.println(" boolean b " + b);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char key = board[i][j];
                if (key != '.')
                    if (!seen.add(key + " in row " + i)
                            || !seen.add(key + " in column " + j)
                            || !seen.add(key + " in block " + i / 3 + " - " + j / 3)) {
                        return false;
                    }
            }
        }
        return true;
    }
}

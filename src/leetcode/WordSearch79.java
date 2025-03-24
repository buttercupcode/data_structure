package leetcode;

import java.util.Objects;

public class WordSearch79 {
    public static void main(String[] args) {
        WordSearch79 w = new WordSearch79();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

//        System.out.println(w.exist(board,"ABCCED"));
//        System.out.println(w.exist(board,"SEE"));
//        System.out.println(w.exist(board,"ABCB"));

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(w.exist(board, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (exist(board, visited, word, i, j, board.length, board[0].length))
                    return true;

            }
        }
        return false;

    }

    public boolean exist(char[][] board, boolean[][] visited, String word, int x, int y, int length, int breadth) {

        if (board[x][y] == word.charAt(0)) {


            String nextString = word.substring(1);
            if (Objects.equals(nextString, ""))
                return true;
            boolean down = x + 1 < length && !visited[x + 1][y]
                    && exist(board, visited, word.substring(1), x + 1, y, length, breadth);
            boolean right = (y + 1 < breadth) && !visited[x][y + 1]
                    && exist(board, visited, word.substring(1), x, y + 1, length, breadth);
            boolean up = (x - 1 >= 0) && !visited[x - 1][y]
                    && exist(board, visited, word.substring(1), x - 1, y, length, breadth);
            boolean left = (y - 1 >= 0) && !visited[x][y - 1]
                    && exist(board, visited, word.substring(1), x, y - 1, length, breadth);
            visited[x][y] = true;
            return up || down || left || right;

        }
        return false;

    }
}

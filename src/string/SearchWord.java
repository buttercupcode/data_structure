package string;

public class SearchWord {
    public static void main(String[] args) {
        SearchWord s = new SearchWord();


        char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(matrix, "ABCCED"));
    }

    /*    public boolean searchWordInMatrix(char[][] matrix, String word){
            List<List<Integer>> result = new ArrayList<>();
            result= exist(matrix, word,0,0,0,result);
           return false;
        }*/
    /*public List<List<Integer>>   search(char[][] matrix,String word, int searchIdx, int h, int v, List<List<Integer>> result ){


        if(matrix[h][v]==word.charAt(searchIdx)) {
            result.add(List.of(h, v));
            if (searchIdx==word.length()-1)
                return result;
            else
                searchIdx++;
        }
        if(isValidCell(h+1,v,matrix))
            search(matrix,word,searchIdx,h+1,v,result);
        if(isValidCell(h,v+1,matrix))
            search(matrix,word,searchIdx,h,v+1,result);
        if(isValidCell(h+1,v+1,matrix))
            search(matrix,word,searchIdx,h+1,v+1,result);
        if(isValidCell(h-1,v,matrix))
            search(matrix,word,searchIdx,h-1,v,result);
        if(isValidCell(h,v-1,matrix))
            search(matrix,word,searchIdx,h,v-1,result);

    }

    public boolean isValidCell(int h,int v, char[][] matrix){
        return v >= 0 && v < matrix.length && h >= 0 && h < matrix[0].length;
    }*/
    public boolean exist(char[][] matrix, String word) {
        char[] c = word.toCharArray();

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) if (exist(matrix, c, x, y, 0)) return true;
        }
        return false;
    }

    public boolean exist(char[][] matrix, char[] word, int x, int y, int i) {
        if (i == word.length) return true;
        if (x < 0 || y < 0 || x == matrix.length || y == matrix[x].length) return false;
        if (matrix[x][y] != word[i]) return false;
        matrix[x][y] ^= 256;
        boolean exist = exist(matrix, word, x + 1, y, i + 1)
                || exist(matrix, word, x, y + 1, i + 1)
                || exist(matrix, word, x - 1, y, i + 1)
                || exist(matrix, word, x, y - 1, i + 1);
        matrix[x][y] ^= 256;
        return exist;

    }
/*public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y=0; y<board.length; y++) {
        for (int x=0; x<board[y].length; x++) {
            if (exist(board, y, x, w, 0)) return true;
        }
    }
    return false;
}

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }*/
}

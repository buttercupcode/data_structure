package leetcode.array.twod;
//2D matrix

public class NumberOfIslands200 {
    public static void main(String[] args) {
        NumberOfIslands200 n  = new NumberOfIslands200();
        char[][] islandMap = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
      int out =  n.numIslands(islandMap);
        System.out.println(out);
    }


    public int numIslands(char[][] grid) {
        int count=0;
        for(int i = 0; i<grid.length ; i++){
            for(int j =0; j<grid.length; j++){
                if(grid[i][j]=='1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid,int row,int col){
        int nr= grid.length;
        int nc= grid[0].length;

        if(row>=nr||col>=nc || row<0 || col<0 || grid[row][col]=='0')
            return ;

            grid[row][col]='0';
             helper(grid,row,col+1);
             helper(grid,row,col-1);
            helper(grid,  row+1,col);
             helper(grid,row-1,col);


    }
}

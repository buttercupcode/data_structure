package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges994
{

    public static void main(String[] args) {
        int[][] test = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges994 r = new RottingOranges994();
        System.out.println(r.orangesRotting(test));
    }
    public int orangesRotting(int[][] grid) {
        int count=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i< grid.length;i++){
            for(int j =0; j< grid[0].length;j++){
                if(grid[i][j]==2){
                    addToQueue(i,j,q,grid);
                }
            }
        }
        while(!q.isEmpty()){
            int n = q.size();
            boolean readyToRot= false;
            for(int i =0; i< n; i++){
                int[] curr= q.poll();
                if(grid[curr[0]][curr[1]]==1){
                    readyToRot= true;
                    addToQueue(curr[0],curr[1],q,grid);
                }
                grid[curr[0]][curr[1]]=2;
            }
            if(readyToRot)
                count++;
        }
        return count;


    }

    void addToQueue(int i, int j, Queue<int[]> q, int[][] grid){
        if(i+1<grid.length && grid[i+1][j]==1){
            q.offer(new int[]{i+1,j});
        }
        if(i-1>=0 && grid[i-1][j]==1){
            q.offer(new int[]{i-1,j});
        }
        if(j+1<grid[0].length && grid[i][j+1]==1)
            q.offer(new int[]{i,j+1});
        if(j-1>=0 && grid[i][j-1]==1)
            q.offer(new int[]{i,j-1});
    }


}
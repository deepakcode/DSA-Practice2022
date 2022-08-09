package com.practice.graph;

public class NoOfIsland {
    public static void main(String[] args) {
        char[][] grid = {{'0','1'},
                        {'1','0'},
                        {'1','1'},
                        {'1','0'}};
        Solution2 s = new Solution2();
        System.out.println("No of island "+s.numIslands(grid));

    }
}

class Solution2 {

    public int numIslands(char[][] grid) {
        int count=0;
        int M=grid.length;
        int N=grid[0].length;
        for(int i=0; i<M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    dfsUtil(grid, i, j, M, N);
                    count++;
                }
            }
        }
        dfsUtil(grid,0,1,M,N);
        System.out.println("------------"+M+" "+N);
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(""+grid[i][j]+" ");
            }
            System.out.println();
        }
        return count;
    }

    public void dfsUtil(char[][] grid, int x,int y, int M, int N){
/**
 *                       {{'0','1'},
*                         {'1','0'},
*                         {'1','1'},
*                         {'1','0'}};
 * */
        if(isValid(x,y,grid,M,N)){
            if(grid[x][y]=='1'){
                grid[x][y]='2';
                dfsUtil(grid,x+1,y,M,N);
                dfsUtil(grid,x-1,y,M,N);
                dfsUtil(grid,x,y+1,M,N);
                dfsUtil(grid,x,y-1,M,N);
                dfsUtil(grid,x-1,y-1,M,N);
                dfsUtil(grid,x+1,y+1,M,N);
                dfsUtil(grid,x-1,y+1,M,N);
                dfsUtil(grid,x+1,y-1,M,N);
            }
        }
    }

    public boolean isValid(int i, int j, char[][] grid, int M,int N){
        if(i>=0 && i<M && j>=0 && j<N){
            return true;
        }
        return false;
    }


}
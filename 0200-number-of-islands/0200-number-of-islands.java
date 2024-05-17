class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]=='1'){
                    numberOfIslands++;
                    dfs(row,col,grid);
                }
            }
        }

        return numberOfIslands;
    }

    public void dfs(int row, int col, char[][] grid){
        if(row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]=='0'){
            return;
        }

        grid[row][col]='0';//updating the given grid will help mark visited islands
        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
}
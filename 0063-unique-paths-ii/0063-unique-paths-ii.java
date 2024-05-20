class Solution {
   
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //1-> obstacle, 0-> space
        //move down or right
        //reach: bottom-right corner: grid[m - 1][n - 1]

        int totalrows = obstacleGrid.length; //3
        int totalcols = obstacleGrid[0].length;//3
       
        int[][] memo = new int[totalrows][totalcols];
        int totalPaths =  explorePaths(obstacleGrid, 0, 0, memo, totalrows, totalcols);
      
        return totalPaths;

    }

/**
[0,2,1],
[0,1,1],
[0,1,1]
 */
    public int explorePaths(int[][] obstacleGrid, int row, int col, int[][] memo, int totalrows, int totalcols){ //0,0
       // int totalrows = obstacleGrid.length; //3
       // int totalcols = obstacleGrid[0].length;//3

        if(col<0||row<0||col>=totalcols||row>=totalrows||obstacleGrid[row][col]==1){
            return 0;
        }
        if(row==totalrows-1 && col ==totalcols-1){
            return 1;
        }

    if(memo[row][col]!=0){
        return memo[row][col];
    }
    else{

        memo[row][col]= explorePaths(obstacleGrid, row, col+1,memo, totalrows, totalcols)+explorePaths(obstacleGrid, row+1,col,memo, totalrows, totalcols);
        return memo[row][col];
    }
    
       


        
    }
}
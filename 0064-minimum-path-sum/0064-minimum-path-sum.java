class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int[][] memo = new int[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(r==0){
                    if(c==0){
                        memo[r][c]=grid[r][c];
                        continue;
                    };
                    memo[r][c]=memo[r][c-1]+grid[r][c];
                }
                if(c==0){
                    if(r!=0){
                        memo[r][c]=memo[r-1][c]+grid[r][c];
                    }
                    continue;
                }
                if(r!=0 && c!=0){
                    memo[r][c]=Math.min(memo[r-1][c],memo[r][c-1])+grid[r][c];
                }


            }
        }

        return memo[rows-1][cols-1];

    /*
       [1,4,5]
       [2,7,6]
       [6,8,7]
    */

    }
}
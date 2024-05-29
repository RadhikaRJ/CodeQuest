class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //need to use memoization

        int[][] memo = new int[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(r==0){
                    memo[r][c]=matrix[r][c];
                }
                else{
                    if(c-1>=0 && c+1<cols){//any in between col
                        memo[r][c] = Math.min(memo[r-1][c-1],Math.min(memo[r-1][c],memo[r-1][c+1]))+matrix[r][c];
                    }
                    else if(c-1<0 && c+1>=cols){ //cols==1
                        memo[r][c] = matrix[r][c]+memo[r-1][c];
                    }
                    else if(c-1<0 && c+1<cols){ //left most col and cols>1
                        memo[r][c] = matrix[r][c]+Math.min(memo[r-1][c],memo[r-1][c+1]);
                    }
                    else if(c-1>=0 && c+1>=cols){//right most col
                        memo[r][c] = matrix[r][c]+Math.min(memo[r-1][c],memo[r-1][c-1]);
                    }
                }
            }
        }


        for(int[] r:memo){
            System.out.println(Arrays.toString(r));
        }

        int res = Integer.MAX_VALUE;
        for(int r=rows-1;r<rows;r++){
            for(int c=0;c<cols;c++){
                res=Math.min(res,memo[r][c]);
            }
        }

        return res;
        
        

        
    }

    
}

/**
Recursion Approach
class Solution {
    int minSum = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int row=0;row<1;row++){
            for(int col=0;col<cols;col++){
                dfs(row,col,matrix,0);
            }
        }


        return minSum;
    }

    private void dfs(int row, int col, int[][] matrix, int pathSum){
        if( row>=matrix.length || col<0 || col>=matrix[0].length){
            return;
        }

        if(row==matrix.length-1){
            minSum = Math.min(minSum,pathSum+matrix[row][col]);
            return;
        }

        dfs(row+1,col, matrix, pathSum+matrix[row][col]); 
        dfs(row+1,col-1, matrix, pathSum+matrix[row][col]);
        dfs(row+1,col+1, matrix, pathSum+matrix[row][col]);


    }
}

 */
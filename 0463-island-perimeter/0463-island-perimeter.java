class Solution {

    int perimeter = 0;
    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean perimeterCalculated = false;

        int[][] track = new int[rows][cols];

        for(int row=0;row<rows; row++){
            for(int col = 0;col<cols; col++){
                System.out.println("row in for: "+row);
                System.out.println("col in for: "+col);
                if(grid[row][col]==1){
                    dfs(row, col, grid, rows, cols, track);
                    perimeterCalculated=true;
                    break;
                } 
            }
            if(perimeterCalculated){
                break;
            }
        }

        for(int[] row1:track){
             System.out.print(Arrays.toString(row1));
             System.out.println();
        }
       

        return perimeter;
        
    }

    /**
    
    
[0, 1, 0, 0]
[1, 1, 1, 0]
[0, 1, 0, 0]
[1, 1, 0, 0]

 */

    public void dfs(int row, int col, int[][] grid, int totalrows, int totalcols, int[][] track){
       // System.out.println("row: "+row);
       // System.out.println("col: "+col);
        if( row <0 || row >= totalrows ||  col <0 || col >=totalcols){
            return;
        }
        if(track[row][col]==1 || grid[row][col]==0){
            return;
        }

        if(row-1<0 )//check top boundary
        {
            perimeter++;
        }
        if(row+1==totalrows)//bottom 
        {
            perimeter++;
        }
        if(col-1<0){ //left
            perimeter++;
        }
        if(col+1==totalcols){
            perimeter++;
        }//right

        if(row-1>=0 && grid[row-1][col]==0){ //top cell is 0
            perimeter++;
        }

        if(row+1<totalrows && grid[row+1][col]==0){ //bottom cell
            perimeter++;
        }

        if(col-1>=0 && grid[row][col-1]==0)//left cell
        {
            perimeter++;
        }
        if(col+1<totalcols && grid[row][col+1]==0){ //right cell
            perimeter++;
        } 


        track[row][col]=1;
        
        if(row+1<totalrows){
            dfs(row+1,col,grid, totalcols, totalrows,track);
        }
        if(row-1>=0){
            dfs(row-1,col,grid, totalcols, totalrows,track);
        }
        if(col+1<totalcols){
            dfs(row,col+1,grid, totalcols, totalrows,track);
        }
        if(col-1>=0){
            dfs(row,col-1,grid, totalcols, totalrows,track);
        }
        

        
        
       


}


}


/**
        perimeter
        boundary cell-> perimeter+1
        row=0 

        matrix[row][col]==1

        also check boundary perimeter+1
        matrix[row+1][col]==0   perimeter+1
        matrix[row-1][col]==0    perimeter+1
        matrix[row][col-1]==0   perimeter+1
        matrix[row+1][col]==0  perimeter+1
//p=3, 6, 9 11 13 16
        perimeter+1


        */
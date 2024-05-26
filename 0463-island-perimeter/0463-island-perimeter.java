class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int up, down, left, right;
        int result = 0;

        for(int r=0;r<rows;r++){
            for(int c = 0; c<cols;c++){

                if(grid[r][c]==1){
                    if(r==0){up=0;}//set as water
                    else{ up = grid[r-1][c];} //set as land if top cell was land

                    if(c==0){
                        left = 0;
                    }
                    else{
                        left = grid[r][c-1];
                    }

                    if(r==rows-1){ down=0;}
                    else {down = grid[r+1][c];}

                    if(c==cols-1){ right = 0;}
                    else{
                        right = grid[r][c+1];
                    }

                    result +=4-(left+right+up+down);
                }

            }
        }

        return result;
    }
}
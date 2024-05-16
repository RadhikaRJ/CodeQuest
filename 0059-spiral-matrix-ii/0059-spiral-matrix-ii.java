class Solution {
    public int[][] generateMatrix(int n) {
        int total_rows = n;
        int total_cols = n;

        int[][] matrix = new int[n][n];
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        
        int val = 1;
        int row=0,col=0;
        while(left<=right || top<=bottom){
            //moving from left to right
             col=left; //set col to 0=left axis
             //row is top currently
            while(col<=right){
                matrix[top][col]=val; 
                val++;
                col++;
            }
            if(left>right){
                break;
            }
           //col exceed right axis, so we need to dec it
           col--;
            top++; //move top axis 1 row below
            row=top; //row=1, move along right axis
            
            //moving from top to bottom
            while(row<=bottom){
                matrix[row][right]=val;
                val++;
                row++;
            }
            if(bottom<top){
                break;
            }
            row--;//bring it back to last row
            right--;//move right axis one col to the left

            col=right;

            //moving from right to left
            while(col>=left){
                matrix[bottom][col]=val;
                val++;
                col--;
            }
            if(left>right){
                break;
            }
            col++;
            bottom--;

            row=bottom;

            //moving from bottom to top
            while(row>=top){
                matrix[row][left]=val;
                val++;
                row--;
            }
            if(top>bottom){
                break;
            }

            row++; //1
            left++;//1

            
        }

        return matrix;

    }
}
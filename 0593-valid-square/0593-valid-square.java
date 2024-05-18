class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
       //sort the points based on x coordinate and if there is a tie, sort based on y coordinate
       //arrangement obtained reflects valid square boundary
       // After sorting: 
       //sides: p0p1, p1p3 ,p3p2 and p2,p0 form sides of the diagonal
       //check for equality
       //Diagonals: p0p3 and p1p2 form the diagonals
       //check for equality


       int[][] p = {p1,p2,p3,p4};
       Arrays.sort(p,(l1,l2)->l2[0]==l1[0] ? l1[1]-l2[1] : l1[0]-l2[0]); 

       return distance(p[0],p[1])!=0 && 
       (distance(p[0],p[1]) == distance(p[1],p[3])) && 
       (distance(p[1],p[3]) == distance(p[3],p[2])) && 
       (distance(p[3],p[2])== distance(p[2],p[0])) && 
       (distance(p[0],p[3]) ==distance(p[1],p[2]));


    }

    public double distance(int[]p1, int[] p2){
        return (p2[1]-p1[1])*(p2[1]-p1[1]) + (p2[0]-p1[0])*(p2[0]-p1[0]);
    }





}


/**
 * 
 * Square has equidistant sides and equal length of diagonals
 * distance formula = sqrt((x1-x2)^2+(y1-y2)^2)
 * simplify by removing the sqrt-> (x1-x2)^2 + (y1-y2)^2
 * 
 * now, there are two lengths of equal distance forming the diagonals
 * 
 * Construct a square
 * 
 * p4      p3
 * ^
 * |
 * p1 ---> p2
 * 
 * diagonals: p1,p3 && p2,p4
 * horizontals: p1,p2 && p3,p4
 * verticals: p1,p4 && p2,p3
 * 
 * & eithe 1 of other possible combinations using 3 points should be true (as if
 * they were the diagonals being formed)
 * 
 * 
 * return isSameLength(p1, p3, p2, p4) &&
 * isSameLength(p1, p2, p3, p4) &&
 * isSameLength(p1, p4, p2, p3) &&
 * (isSameLength(p1, p2, p2, p3)
 * || isSameLength(p1, p3, p2, p3)
 * || isSameLength(p1, p2, p1, p3) );
 * }
 * 
 * public static int distanceSquare(int[] p1, int[] p2) {
 * int xSquare = (p1[0] - p2[0]) * (p1[0] - p2[0]);
 * int ySquare = (p1[1] - p2[1]) * (p1[1] - p2[1]);
 * return xSquare + ySquare;
 * }
 * 
 * public static boolean isSameLength(int[] p1, int[] p2, int[] p3, int[] p4) {
 * return distanceSquare(p1, p2) == distanceSquare(p3, p4) && distanceSquare(p1,
 * p2) != 0;
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 */
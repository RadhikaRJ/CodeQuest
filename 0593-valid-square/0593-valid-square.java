class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        /**
         * Square has equidistant sides and equal length of diagonals
         * distance formula = sqrt((x1-x2)^2+(y1-y2)^2)
         * simplify by removing the sqrt-> (x1-x2)^2 + (y1-y2)^2
         * 
         * now, there are two lengths of equal distance forming the diagonals
         * 
         * 
         * 
         */
        return isSameLength(p1, p3, p2, p4) &&
                isSameLength(p1, p2, p3, p4) &&
                isSameLength(p1, p4, p2, p3) &&
                (isSameLength(p1, p2, p2, p3)
                        || isSameLength(p1, p3, p2, p3)
                      || isSameLength(p1, p2, p1, p3)  );
    }

    public static int distanceSquare(int[] p1, int[] p2) {
        int xSquare = (p1[0] - p2[0]) * (p1[0] - p2[0]);
        int ySquare = (p1[1] - p2[1]) * (p1[1] - p2[1]);
        return xSquare + ySquare;
    }

    public static boolean isSameLength(int[] p1, int[] p2, int[] p3, int[] p4) {
        return distanceSquare(p1, p2) == distanceSquare(p3, p4) && distanceSquare(p1, p2) != 0;
    }

}
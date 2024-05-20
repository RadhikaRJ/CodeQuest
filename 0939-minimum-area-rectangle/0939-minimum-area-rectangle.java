class Solution {
    public int minAreaRect(int[][] points) {
       int minArea = Integer.MAX_VALUE;
        /**
        x1,y1   x2y1
        
        
        x1y2     x2y2
         */     
        Map<Integer,List<Integer>> mapX = new HashMap<>();
       
       for(int[] point:points)
       {
            int x1 = point[0];
            int y1 = point[1];
            mapX.computeIfAbsent(x1, k -> new ArrayList<>()).add(y1);
       }

       //System.out.println(mapX);

       for(int[] A:points){
        for(int[] B: points){
            if(A[0]!=B[0] && A[1]!=B[1]){
                int x1 = A[0], y1 = A[1];
                int x2 = B[0], y2 = B[1];
                if(mapX.get(x1).contains(y2) && mapX.get(x2).contains(y1)){
                    int area = Math.abs(x2-x1)*Math.abs(y2-y1);
                    minArea = Math.min(minArea, area);
                }
            }
        }
       }


       return (minArea == Integer.MAX_VALUE) ? 0:minArea;

    }
}
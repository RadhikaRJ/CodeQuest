class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)-> (y-x));
       
   
        int n = stones.length;
        for(int i=n-1;i>=0;i--){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int x = pq.poll();//larger
            int y = pq.poll();
            if(x==y){
                continue;
            }
            else{
                pq.add(Math.abs(x-y));
            }
        }

        return pq.size()==0 ? 0: pq.poll();

        


    }

   
}
//Dry run
//[2,7,4,1,8,1]
//[1,2,2,4,7,14]. 7
//x=8
//y=7
//1
/*


 



//
*/
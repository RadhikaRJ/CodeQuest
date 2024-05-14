class Solution {
    List<List<Integer>> result = new ArrayList<>();
   
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // [1,1,2,5,6,7,10]

        Arrays.sort(candidates);
        
          
        findCombinations(candidates, target, new ArrayList<>(), 0, 0);
            
           
        

        return result;

    }

    public void findCombinations(int[] candidates, int target, List<Integer> list, int sum, int index){

         System.out.println("beginning "+list.size());
         if(index>candidates.length || sum>target){
            return;
        }
        if(sum==target){
             System.out.println("adding to result: "+list.size());
             List<Integer> listNew = new ArrayList<>(list);
            result.add(listNew);
            return;
        }
          // 0,1,2,3,4,5,6,7,8
          //[1,1,1,1,2,2,2,5,6,7,10]
       
        for(int i=index;i<candidates.length;i++) 
        {
            System.out.println("inside for loop: "+list.size());
           
            if(i!=index && candidates[i]==candidates[i-1]){
                System.out.println("i :"+i);
                continue;
            }
            if(sum+candidates[index]<=target){
                list.add(candidates[i]);
                sum=sum+candidates[i];
                findCombinations(candidates,target,list,sum,i+1);
                list.remove(list.size()-1);
                sum=sum-candidates[i];
            }
        }
        ////index=0, i=0, sum=1, [1,] 
        //  findCombinations(candidates,target,list,1,1)
            //i=5 sum=3 [1,2,5]
                
        
    
    }
}

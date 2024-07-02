class Solution {
    public int subarraySum(int[] nums, int k) {

    //Method 3 using hashmap
    //TC: O(N), S: O(N)
    //If The cumulative sum up to two indices is the same, sum[i] = sum[j],  
    //then sum[i] -sum[j] = 0
    //Similarly, if the cumulatyive sum of 2 indices, sai i & j, ias at a difference of k
    //sum[i] - sum[j] =k, then sum of elements lying begtween indices i & j is k.
    
    //Use hashmap to store cumulative sum of upto all indices and 
    //the frequency of occurrence of each of the cumulative sum
    //

    int count = 0, sum = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int n = nums.length;
    for(int i=0;i<n;i++){
        sum+=nums[i];
        if(map.containsKey(sum-k)){ //sum[i]-sum[j]=k, then sum[i]-k=sum[j] (similarly with sum[j])
            count+=map.get(sum-k);
           
        }
        map.put(sum, map.getOrDefault(sum,0)+1);
    }
    return count;

    }
}

/**

Method 1
 int totalSubarraySum = 0;
       
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for(int j=i;j<nums.length;j++){
                 sum+=nums[j];
                if(sum==k){
                    totalSubarraySum++;
                }
               
            }
        }

        return totalSubarraySum;


      TC:  O(N^2)
      Space: O(1)

Method 2
//cumulative sum array
        int n = nums.length;
        int count = 0;

        //cumulative sum array
        int[] sum = new int[n+1]; //+1 
        sum[0] = 0;
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+nums[i-1]; //nums is till i-1
        }
        for(int start = 0; start<n;start++){
            for(int end = start+1; end<=n;end++){
                if(sum[end]-sum[start]==k){
                    count++;
                }
            }
        }

        return count;

       TC: O(N^2)
       Space: O(N)


 */
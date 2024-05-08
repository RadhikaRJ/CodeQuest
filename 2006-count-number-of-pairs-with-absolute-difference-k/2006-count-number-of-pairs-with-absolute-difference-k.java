class Solution {
    public int countKDifference(int[] nums, int k) {
        int pairCount = 0;
        // int n =nums.length;
        // for(int i=0;i<n-1;i++){
        //     for(int j = i+1;j<n;j++){
        //         if(Math.abs(nums[i]-nums[j])==k){
        //             pairCount++;
        //         }
        //     }
        // }


        //Another optimal solution is to use the fact that i+j=k => j=i-k for i>=k
        //array to store frequency of occurrence of nums, 1 <= nums[i] <= 100
        int[] frequency = new int[101]; //disregard 0, we need 100 more so 101
        //update the frequency
        for(int n:nums){
            frequency[n]++;
        }

        for(int i=k;i<=100;i++){
            pairCount+= frequency[i] * frequency[i-k]; //frequency of i * frequency of j (j=i-k) will give the total pairs possible with difference =k
        }


        return pairCount;
    }


}
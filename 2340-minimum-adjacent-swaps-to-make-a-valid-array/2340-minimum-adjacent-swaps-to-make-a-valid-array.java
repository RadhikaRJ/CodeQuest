class Solution {
    public int minimumSwaps(int[] nums) {
     //  [3,4,5,5,3,1 ]
     //  [0,1,2,3,4,5 ]
     //  [1,3,4,5,3,5 ]

    int maxPosition = nums.length-1, minPosition = 0;
    int currentMaxIndex = 0, currentMinIndex = 0;
    int totalSwaps = 0;
    for(int i=0;i<nums.length;i++){
        if(nums[currentMaxIndex]<=nums[i]){
            currentMaxIndex = i;
        }
        if(nums[currentMinIndex]>nums[i]){
            currentMinIndex = i;
        }
    }

   int  swaps = currentMinIndex-1;
    swaps+=nums.length-currentMaxIndex;
    if(currentMinIndex>currentMaxIndex){
        swaps-=1;
    }

    return swaps;


    }
}
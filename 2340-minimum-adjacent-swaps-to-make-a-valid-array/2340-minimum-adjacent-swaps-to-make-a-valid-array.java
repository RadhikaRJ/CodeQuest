class Solution {
    public int minimumSwaps(int[] nums) {
        
        int n = nums.length;
       
        int indexOfSmallestNum = 0;
        int indexOfLargestNum =0;

        

        for(int i=0;i<nums.length;i++){
            if(nums[indexOfLargestNum]<=nums[i]){
                indexOfLargestNum = i;
            }
            if(nums[indexOfSmallestNum]>nums[i]){
                indexOfSmallestNum = i;
                
            }
        }

        int minSwapsLargestToRight = n-indexOfLargestNum;
        int minSwapsSmallestToLeft= indexOfSmallestNum-1;
        int totalSwaps = minSwapsLargestToRight+minSwapsSmallestToLeft;
       

        return indexOfSmallestNum>indexOfLargestNum ? totalSwaps-1:totalSwaps;
    }
}
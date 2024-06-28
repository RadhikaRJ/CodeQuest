class Solution {
    public int minimumSwaps(int[] nums) {
        
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int indexOfSmallestNum = 0;
        int indexOfLargestNum =0;

        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(maxNumber<=nums[i]){
                indexOfLargestNum = i;
                maxNumber = nums[i];
            }
            if(minNumber>=nums[i]){
                indexOfSmallestNum = i;
                minNumber = nums[i];
            }
        }

        int minSwapsLargestToRight = n-indexOfLargestNum;
        int minSwapsSmallestToLeft= indexOfSmallestNum-1;
        int totalSwaps = minSwapsLargestToRight+minSwapsSmallestToLeft;
       

        return indexOfSmallestNum>indexOfLargestNum ? totalSwaps-1:totalSwaps;
    }
}
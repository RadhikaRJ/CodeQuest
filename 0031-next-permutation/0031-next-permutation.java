class Solution {
    public void nextPermutation(int[] nums) {
       int i = nums.length-2;
       while(i>=0 && nums[i+1]<=nums[i]){ 
        //158 4 76531 --> Find index of  4 as it is 1st decreasing element from right
        i--;
       }
        //158 4 76531
        //then find the index of 1st elemengt from right that is > 4
       if(i>=0){
        int j=nums.length-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        swap(nums,i,j); 
       }

       //158576431
       //reverse elements after index i: --> 158513467
       reverse(nums,i+1);
    }

    public void reverse(int[]nums, int start){
        int i=start,j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
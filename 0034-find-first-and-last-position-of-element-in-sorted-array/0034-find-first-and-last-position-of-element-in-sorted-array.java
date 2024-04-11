class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1,-1};
        if(nums.length==0||nums[0]>target||nums[n-1]<target){ //take care of these edge cases initially.
            return result;
        }
        
        result[0] = findFirstOccurrence(nums,target);
        result[1] = findLastOccurrence(nums,target);

        return result;



    }

    private int findLastOccurrence(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
       
        return nums[right]==target?right:-1;
    }

    private int findFirstOccurrence(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right = mid-1;
            }
            else{
                left=mid+1;
            }
        }
        if(left<0){
            return -1;
        }
        return nums[left]==target?left:-1;

    }
}
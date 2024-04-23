class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==1 && nums[0]!=target){
            return false;
        }
        else if(nums.length == 1 && nums[0]==target){
            return true;
        }
        boolean isPresent = false;
        int index = -1;
        int pivotIndex = getPivotIndex(nums);
        if(pivotIndex == -1){//not rotated
            index = binarySearch(nums, target, 0, nums.length-1);
            if(index!=-1){
                return true;
            }
            else{
                return false;
            }
        }

        index = binarySearch(nums,target, 0, pivotIndex);
        if(index == -1){
            index = binarySearch(nums,target, pivotIndex+1, nums.length-1);
        }

        return index!=-1;



    }

    public int getPivotIndex(int[] nums){
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid < right && nums[mid]>nums[mid+1]){ 
                // m m+1
                // 7,0
                return mid;
            }
            if(mid > left && nums[mid]<nums[mid-1]){
                //m-1 m
                //7 0
                return mid-1;
            }
           //if elements at start, mid & end are duplicates, then skip these duplicates
           //NOTE: the elements of start or end could be pivots, so check if they are pivots before skipping them


          if(nums[left]==nums[mid] && nums[mid]==nums[right]){ 
            if(left<right && nums[left]>nums[left+1]){ 
                //7,0
                //s.s+1
                return left;
            }
            left++;//skip action
            if(right > left && nums[right]<nums[right-1]){
                // r-1 r
                // 7. 0
                return right-1;
            }
            right--;//skip action
           }
           else if(nums[left]<nums[mid]||nums[left]==nums[mid] && nums[right]<nums[mid]){
                left = mid+1;
           }
           else{
            right = mid-1;
           }
           
        }

        return -1;
    }

    public int binarySearch(int[] nums, int target, int left, int right){
        int index = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                index = mid;
                break;
            }
            if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return index;
    }
}
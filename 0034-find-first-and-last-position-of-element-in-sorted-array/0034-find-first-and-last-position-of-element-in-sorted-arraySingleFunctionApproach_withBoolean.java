class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = { -1, -1 };
        // if (nums.length == 0 || nums[0] > target || nums[n - 1] < target) { // take care of these edge cases initially.
        //     return result;
        // }

        result[0] = binarySearchOccurrence(nums, target, true);
        result[1] = binarySearchOccurrence(nums, target, false);

        return result;

    }

    private int binarySearchOccurrence(int[] nums, int target, boolean firstOccurrence) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid]< target) {
                left = mid + 1;
            }
            else {
                ans = mid;
                if(firstOccurrence){
                    right = mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }

        return ans;
    }

   
}
class Solution {
    public int search(int[] nums, int target) {
        int index = -1;

        int pivotIndex = findPivotIndex(nums);
        System.out.println("pivotIndex: " + pivotIndex);

        if (pivotIndex == -1) {
            index = binarySearch(nums, target, 0, nums.length - 1);
            return index;
        }

        index = binarySearch(nums, target, 0, pivotIndex);
        if (index == -1) {
            index = binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
        }

        return index;

    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    /**
     * [3,4,5,6,7,0,1,2]
     * 0,1,2,3,4,5,6,7
     * l. m. r
     * 
     * m m+1
     * 7,0 --> descending
     * Case 1: mid > mid+1 --> pivot is mid
     * 
     * 
     * m-1, m
     * 7, 0
     * Case 2: mid < (mid-1) --> pivot is mid-1
     * 
     * 4,5,6,3,2,1,0
     * l. m. r
     * Case 3: left(value 4) >= mid(value 3) so all elements after mid will be
     * smaller than start
     * so ignore these values beyond mid as we are searching for peak element.
     * So set right = mid-1;
     * 
     * Case 4: left element is smaller than mid element
     * 3,4,5,6,2
     * l m. r
     * 
     * left element < mid element
     * so left = mid+1;
     * (If mid was peak, it would have been returned by case 1 or 2.
     * Its not returned, which means there is a peak value beyond mid.)
     */
    private int findPivotIndex(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 4 conditions for finding pivot
            // 4,5,6,7,1,2,3 mid 7 > 1
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // 6,7,1,2,3 mid = 1, nums[mid-1]=7 > 1->nums[mid]
            if (mid > left && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }
            //
            if (nums[mid] <= nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;

    }

}
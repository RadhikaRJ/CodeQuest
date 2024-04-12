class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int start = 0, end = arr.length-1;
        int mid = 0;
        while(start<=end){
            mid = start+(end-start)/2;
            if(mid+1<arr.length && mid>0 && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid]<arr[mid+1]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return mid;
    }
}
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
/**
 * [1,2,3,4,5,3,1]
 * 
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
       
        int size = mountainArr.length();
        System.out.println("size: "+size);

        int peakIndex = peakElementIndex(mountainArr,size);
        System.out.println("peakIndex: "+peakIndex);

        int firstIndex = orderAgnosticBS(target,mountainArr, 0,peakIndex);
        System.out.println("firstIndex: "+firstIndex);

        if(firstIndex!=-1){
            return firstIndex;
        }
        
        int index =  orderAgnosticBS(target,mountainArr,peakIndex+1,size-1);
        System.out.println("index: "+index);
        return index;

    }

    // get the peakElementIndex
    public int peakElementIndex(MountainArray mountainArr, int size) {
        int left = 0, right = size - 1;
     
        while (left<right) {
         int mid = left+(right-left)/2;
         if(mountainArr.get(mid)>mountainArr.get(mid+1)){
            right = mid;
         }
         else{
            left = mid+1;
         }
        }

        return left;
    }

    //
    public int orderAgnosticBS(int target, MountainArray mountainArr, int left, int right) {

        boolean isAscending = mountainArr.get(left)<mountainArr.get(right); //if increasing, then true

        int index = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midValue = mountainArr.get(mid);
            if(target == midValue){
                index = mid;
                break;
               
            }
           else if(isAscending)
           {
                if(target>midValue){
                    left=mid+1;
                }
                else{
                    right = mid-1;
                }
           }
           else
           {
                if(target>midValue){ //descending order, mid element is smaller, check on left half
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
           }
        }

        return index;

    }

}
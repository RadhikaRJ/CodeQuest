class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int start = 0;
        int end = height.length-1;

        while(start<end){
            int len = end-start;
            int h = Math.min(height[start],height[end]);
            area = Math.max(area,len*h);
            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
        }

        return area;

    }
}
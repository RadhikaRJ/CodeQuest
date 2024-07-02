class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int niceSubarrays = 0;
        int n = nums.length;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(currSum,1);

        for(int i=0;i<nums.length;i++){
            currSum += nums[i]%2;

            if(map.containsKey(currSum-k)){
                niceSubarrays = niceSubarrays + map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }

        return niceSubarrays;

       
    }
}
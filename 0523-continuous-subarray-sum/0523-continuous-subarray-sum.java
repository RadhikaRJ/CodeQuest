class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixModValue = 0;
        HashMap<Integer,Integer> modVisited = new HashMap<>();

        modVisited.put(0,-1);

        for(int i=0;i<nums.length;i++){
            prefixModValue = (prefixModValue + nums[i]) % k;
            if(modVisited.containsKey(prefixModValue)){
                if(i-modVisited.get(prefixModValue) > 1){
                    return true;
                }
            }
            else{
                modVisited.put(prefixModValue,i);
            }

        }

        return false;
    }
}
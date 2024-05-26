class Solution {
    
    Set<Integer> daysToTravel = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        Arrays.fill(dp,-1);

        for(int day:days){
            daysToTravel.add(day);
        }

        return findMinCost(days,costs,dp,1);
        
    }

    private int findMinCost(int[] days, int[] costs, int[] dp, int currentDay){

        if(currentDay>days[days.length-1]){
            return 0;
        }

        if(!daysToTravel.contains(currentDay)){
            return findMinCost(days,costs,dp,currentDay+1);
        }

        if(dp[currentDay]!=-1){
            return dp[currentDay];
        }

        int oneDayCost = costs[0]+findMinCost(days,costs,dp,currentDay+1);
        int sevenDayCost = costs[1]+findMinCost(days,costs,dp,currentDay+7);
        int thirtyDayCost = costs[2]+findMinCost(days,costs,dp,currentDay+30);

        dp[currentDay] = Math.min(oneDayCost,Math.min(sevenDayCost,thirtyDayCost));
        return dp[currentDay];
    }
}
class Solution {
    
    public int climbStairs(int n) {
        //memoization
        int[] memo = new int[n+1];
         
         return solve(0,n,memo);

        
    }

    public int solve(int  curr, int n, int[] memo){
        if(curr>n){
            return 0;
        }

        if(curr == n){
            return 1;
        }

        if(memo[curr]>0){
            return memo[curr];
        }

        memo[curr] = solve(curr+1, n, memo) + solve(curr+2, n, memo);

        return memo[curr];
    }

   
}

/**
Basic recursion approach TLE
int ways = 0;
    public int climbStairs(int n) {

      dfs(n,0);
      return ways;
    }

    private void dfs(int n, int current){
        if(current > n){
            return;
        }
        if(current == n){
            ways++;
            return;
        }

        dfs(n, current+1);
        
        dfs(n,current+2);
        
    }


 */
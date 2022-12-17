
public class Questions {
    public int climbStairs(int N) {
        int[] memo= new int[N + 1];
        for(int n=0; n<=N; n++){
            if(n==0 || n==1){ // total number of ways to reach 0 is 1 (just stay here)
                memo[n]=1;
                continue;
            }
    
            // if(memo[n]!=0) return memo[n];
    
            int ans = memo[n-1] + memo[n-2]; //fib_memo(n-1,memo) + fib_memo(n-2,memo);
    
            memo[n]=ans;
        }

        return memo[N];
    }

    // https://course.acciojob.com/idle?question=f1efff99-71e0-47ad-8cdc-30349259deaa
    public int countWays(int idx, int[] arr){
        if(idx == arr.length){
            return 1;
        }

        int ans = 0;
        for(int jump=1; jump<=arr[idx]; jump++){
            if(idx + jump <= arr.length)
                ans += countWays(idx+jump, arr);
        }

        return ans;
    }
    
    public int countWays_memo(int idx, int[] arr, int[] memo){
        if(idx == arr.length){
            return memo[idx]=1;
        }

        if(memo[idx]!=0) return memo[idx];

        int ans = 0;
        for(int jump=1; jump<=arr[idx]; jump++){
            if(idx + jump <= arr.length)
                ans += countWays_memo(idx+jump, arr,memo);
        }

        return memo[idx] = ans;
    }

    public int countWays_tabulation(int idx, int[] arr, int[] memo){
        for(idx=arr.length; idx>=0; idx--){
            if(idx == arr.length){
                memo[idx]=1;
                continue;
            }
    
            int ans = 0;
            for(int jump=1; jump<=arr[idx]; jump++){
                if(idx + jump <= arr.length)
                    ans += memo[idx+jump]; //countWays_memo(idx+jump, arr,memo);
            }
    
            memo[idx] = ans;
        }

        return memo[0];
    }

    public int stairWays(int[] arr) {
        int n =  arr.length;
        int[] memo = new int[n+1];
        return countWays_tabulation(0, arr,memo);
        // return countWays_memo(0,arr,memo);
        // return countWays(0,arr);
    }

    // stickler thief
    public int findMax(int idx, int[] arr){
        if(idx == arr.length){
            return 0;
        }

        int rob=arr[idx];
        int notRob=0;

        if(idx+2<=arr.length)
            rob += findMax(idx+2, arr);
        
        notRob = findMax(idx+1, arr);

        int ans = Math.max(rob,notRob);

        return ans;
    }

    public int findMax_memo(int idx, int[] arr, int[] memo){
        if(idx == arr.length){
            return memo[idx]=0;
        }

        if(memo[idx]!=0) return memo[idx];

        int rob=arr[idx];
        int notRob=0;

        if(idx+2<=arr.length)
            rob += findMax_memo(idx+2, arr,memo);
        
        notRob = findMax_memo(idx+1, arr,memo);

        int ans = Math.max(rob,notRob);

        return memo[idx]=ans;
    }

    public int findMax_tabulation(int idx, int[] arr, int[] memo){
        for(idx=arr.length; idx>=0; idx--){
            if(idx == arr.length){
                memo[idx]=0;
                continue;
            }
    
            int rob=arr[idx];
            int notRob=0;
    
            if(idx+2<=arr.length)
                rob += memo[idx+2];//findMax_memo(idx+2, arr,memo);
            
            notRob = memo[idx+1]; //findMax_memo(idx+1, arr,memo);
    
            int ans = Math.max(rob,notRob);
    
            memo[idx]=ans;
        }

        return memo[0];
    }

    public int FindMaxSum(int arr[], int n){
        int[] memo= new int[n+1];
        return findMax_tabulation(0, arr, memo);
        // return findMax_memo(0, arr,memo);
        // return findMax(0,arr);
    }

    // leet 746 ==================================

    public int minCost_rec(int[] cost, int idx){
        if(idx == cost.length){
            return 0;
        }

        int oneStep = minCost_rec(cost,idx+1);

        int twoStep = Integer.MAX_VALUE;
        if(idx + 2 <= cost.length){
            twoStep = minCost_rec(cost,idx+2);
        }

        int ans = cost[idx] + Math.min(oneStep,twoStep);

        return ans;        
    }

    public int minCost_memo(int[] cost, int idx, int[] dp){
        if(idx == cost.length){
            return dp[idx]=0;
        }

        if(dp[idx]!=0) return dp[idx];

        int oneStep = minCost_memo(cost,idx+1,dp);

        int twoStep = Integer.MAX_VALUE;
        if(idx + 2 <= cost.length){
            twoStep = minCost_memo(cost,idx+2,dp);
        }

        int ans = cost[idx] + Math.min(oneStep,twoStep);

        return dp[idx]=ans;  
    }

    public int minCost_tab(int[] cost, int[] dp){
        for(int idx = cost.length; idx>=0; idx--){
            if(idx == cost.length){
                dp[idx]=0;
                continue;
            }
    
            int oneStep = dp[idx+1]; //minCost_memo(cost,idx+1,dp);
    
            int twoStep = Integer.MAX_VALUE;
            if(idx + 2 <= cost.length){
                twoStep = dp[idx+2]; //minCost_memo(cost,idx+2,dp);
            }
    
            int ans = cost[idx] + Math.min(oneStep,twoStep);
    
            dp[idx]=ans; 
        }
        return Math.min(dp[0],dp[1]);
    }
    public int minCost_tab_mostOptimized(int[] cost){
        int n = cost.length;
        int idxp1 = cost[n-1];
        int idxp2 = 0;

        for(int idx = n-2; idx>=0; idx--){
            int ansIdx = cost[idx] + Math.min(idxp1,idxp2);

            idxp2 = idxp1;
            idxp1 = ansIdx;
        }        
        return Math.min(idxp1,idxp2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int startingWithZero = minCost_rec(cost,0);
        // int startingWithOne = minCost_rec(cost,1);

        // int startingWithZero = minCost_memo(cost,0,new int[n+1]);
        // int startingWithOne = minCost_memo(cost,1,new int[n+1]);

        return minCost_tab(cost,new int[n+1]);

        // return Math.min(startingWithZero,startingWithOne);
    }

    // homework 

    // https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261
    public static void main(String[] args) {
        
    }
}

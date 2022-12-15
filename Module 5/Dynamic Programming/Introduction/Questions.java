
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
    public static void main(String[] args) {
        
    }
}

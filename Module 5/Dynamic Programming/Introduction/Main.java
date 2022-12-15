public class Main {
    public static int fib_rec(int n){
        if(n==0 || n==1){
            return n;
        }

        int ans = fib_rec(n-1) + fib_rec(n-2);

        return ans;
    }

    public static int fib_memo(int n, int[] memo){
        if(n==0 || n==1){
            return memo[n]=n;
        }

        if(memo[n]!=0) return memo[n];

        int ans = fib_memo(n-1,memo) + fib_memo(n-2,memo);

        return memo[n]=ans;
    }

    public static int tabulation(int N, int[] memo){
        for(int n=0; n<=N; n++){
            if(n==0 || n==1){
                memo[n]=n;
                continue;
            }
    
            // if(memo[n]!=0) return memo[n];
    
            int ans = memo[n-1] + memo[n-2]; //fib_memo(n-1,memo) + fib_memo(n-2,memo);
    
            memo[n]=ans;
        }

        return memo[N];
    }
    public static int tabulation(int N){
        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int n=2; n<=N; n++){
            int ans = dp[n-1] + dp[n-2]; //fib_dp(n-1,dp) + fib_dp(n-2,dp);
    
            dp[n]=ans;
        }

        return dp[N];
    }

    public static int fib_most_optimized(int n){
        int f=0;
        int s=1;
        int t = f + s;

        for(int i=2; i<=n; i++){
            t = f + s;
            f = s;
            s = t;
        }

        return t;
    }
    public static void main(String[] args) {
        int n = 7;

        int[] memo = new int[n+1];
        int ans = fib_memo(n,memo);
        System.out.println(ans);
    }    
}

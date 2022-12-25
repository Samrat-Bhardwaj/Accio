public class Contest2 {
    // https://course.acciojob.com/idle?question=be24b59d-583c-4251-a7e1-d2cb0b6c8e48
    public static int solve_rec(int n){
        if(n==0){
            return 0;
        }

        int temp=n;
        int ans = Integer.MAX_VALUE;

        while(temp!=0){
            int r = temp%10;

            if(r!=0)
                ans=Math.min(ans,solve_rec(n-r)+1);

            temp/=10;
        }

        return ans;
    }

    public static int solve_memo(int n, int[] dp){
        if(n==0){
            return 0;
        }

        if(dp[n]!=0) return dp[n];

        int temp=n;
        int ans = Integer.MAX_VALUE;

        while(temp!=0){
            int r = temp%10;

            if(r!=0)
                ans=Math.min(ans,solve_memo(n-r,dp)+1);

            temp/=10;
        }

        return dp[n]=ans;
    }

    public static int solve_tab(int N, int[] dp){
        for(int n=0; n<=N; n++){
            if(n==0){
                dp[n]=0;
                continue;
            }
    
            int temp=n;
            int ans = Integer.MAX_VALUE;
    
            while(temp!=0){
                int r = temp%10;
    
                if(r!=0)
                    ans=Math.min(ans,dp[n-r]+1);//solve_memo(n-r,dp)+1);
    
                temp/=10;
            }
    
            dp[n]=ans;
        }
        return dp[N];
    }

    public static int solve(int n){
        int[] memo = new int[n+1];
        // return solve_memo(n,memo);
        return solve_tab(n, memo);
        // return solve_rec(n);
    }

    public static int solve_rec(int[] arr, int i, int j){
        if(i+1 == j){
            return Math.max(arr[i],arr[j]);
        }

        if(i==j){
            return arr[i];
        }

        int ans = 0;
        int takeFirst = arr[i] + Math.min(solve_rec(arr,i+2,j),solve_rec(arr,i+1,j-1));
        int takeLast = arr[j] + Math.min(solve_rec(arr,i+1,j-1),solve_rec(arr, i, j-2));

        ans = Math.max(takeFirst, takeLast);

        return ans;
    }

    public static int solve_memo(int[] arr, int i, int j, int[][] dp){
        if(i+1 == j){
            return dp[i][j] = Math.max(arr[i],arr[j]);
        }

        if(i==j){
            return dp[i][j] = arr[i];
        }

        if(dp[i][j]!=0) return dp[i][j];

        int ans = 0;
        int takeFirst = arr[i] + Math.min(solve_memo(arr,i+2,j,dp),solve_memo(arr,i+1,j-1,dp));
        int takeLast = arr[j] + Math.min(solve_memo(arr,i+1,j-1,dp),solve_memo(arr, i, j-2,dp));

        ans = Math.max(takeFirst, takeLast);

        return dp[i][j] = ans;
    }

    public static int solve_tab(int[] arr, int i, int j, int[][] dp){
        int n = arr.length;
        for(int diag=0; diag<n; diag++){
            for(i=0,j=diag; j<n; i++,j++){
                if(i+1 == j){
                    dp[i][j] = Math.max(arr[i],arr[j]);
                    continue;
                }
        
                if(i==j){
                    dp[i][j] = arr[i];
                    continue;
                }
        
                int ans = 0;
                int takeFirst = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]); //Math.min(solve_memo(arr,i+2,j,dp),solve_memo(arr,i+1,j-1,dp));
                int takeLast = arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]);  //Math.min(solve_memo(arr,i+1,j-1,dp),solve_memo(arr, i, j-2,dp));
        
                ans = Math.max(takeFirst, takeLast);
        
                dp[i][j] = ans;
            }
        }

        return dp[0][n-1];
    }

    static long mod = (long)1e9 + 7;
    public static long rec(int n, int k){
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }

        long ans = (rec(n-1,k) + rec(n-2,k))*(k-1);

        return ans%mod;
    }

    public static long memo(int n, int k, long[] dp){
        if(n==1){
            return dp[n]=k;
        }
        if(n==2){
            return dp[n]=k*k;
        }

        if(dp[n]!=0) return dp[n]%mod;

        long ans = ((memo(n-1,k,dp) + memo(n-2,k,dp)))*(k-1);

        return dp[n] = ans%mod;
    }

    public static long tab(int N, int k, long[] dp){
        for(int n=1; n<=N; n++){
            if(n==1){
                dp[n]=k;
                continue;
            }

            if(n==2){
                dp[n]=k*k;
                continue;
            }
    
            // long ans = (dp[n-1]+dp[n-2])*(k-1);
            long ans = (((dp[n-1]*(k-1))%mod + (dp[n-2]*(k-1))%mod)+mod)%mod;
    
            dp[n] = ans%mod;
        }
        return dp[N];
    }

    public static int solve(int n, int k) {
        long[] memo = new long[n+1];
        // return (int)rec(n,k);
        // return (int)memo(n,k,memo);
        return (int)tab(n,k,memo);
    }

    public static int solve(int[] arr){
        int n = arr.length;
        int[][] memo = new int[n][n];
        // return solve_rec(arr,0,n-1);
        // return solve_memo(arr,0,n-1,memo);
        return solve_tab(arr, 0, n-1, memo);
    }
    public static void main(String[] args) {
        
    }
}

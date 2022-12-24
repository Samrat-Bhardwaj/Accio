public class Catalan {
    public static int uniqueBST_rec(int n){
        if(n<=1){
            return 1;
        }

        int ans=0;
        for(int i=1; i<=n; i++){
            int left = uniqueBST_rec(i-1);
            int right = uniqueBST_rec(n-i);
            // int curr_ans = uniqueBST_rec(i-1) * uniqueBST_rec(n-i);

            ans+=(left*right);
        }

        return ans;
    }

    public static int uniqueBST_memo(int n, int[] dp){
        if(n<=1){
            return 1;
        }

        if(dp[n]!=0) return dp[n];

        int ans=0;
        for(int i=1; i<=n; i++){
            int left = uniqueBST_memo(i-1,dp);
            int right = uniqueBST_memo(n-i,dp);
            // int curr_ans = uniqueBST_rec(i-1) * uniqueBST_rec(n-i);

            ans+=(left*right);
        }

        return dp[n] = ans;
    }
    public static int uniqueBST(int n) {
        int[] memo = new int[n+1];
        return uniqueBST_memo(n, memo);
        // return uniqueBST_rec(n);
     }

     // homework 
    //  https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1
    public static void main(String[] args) {
        
    }
}

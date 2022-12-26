public class Buy_and_sell_stocks {
    // buy and sell stocks 1 (leetcode 121) ==========================================================
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp0 = new int[n];
        int[] dp1 = new int[n];

        for(int i=0; i<n; i++){
            if(i==0){
                dp0[i] = 0;
                dp1[i] = - prices[i]; 
                continue;
            }

            dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
            dp1[i] = Math.max(dp1[i-1],0-prices[i]);
        }

        return dp0[n-1];
    }

    // buy and sell stocks 1 (leetcode 121) BETTER =================================================== 
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            // dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            // dp1[i] = Math.max(dp1[i-1],0-prices[i]);
            dpi1 = Math.max(dpi1, 0-prices[i]);
        }

        return dpi0;
    }

    // buy and sell stocks 2 (leetcode 122) ==========================================================
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp0 = new int[n];
        int[] dp1 = new int[n];

        for(int i=0; i<n; i++){
            if(i==0){
                dp0[i] = 0;
                dp1[i] = - prices[i]; 
                continue;
            }

            dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
            dp1[i] = Math.max(dp1[i-1],dp0[i-1]-prices[i]);
        }

        return dp0[n-1];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            int dpi0_prev = dpi0;
            
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpi0_prev - prices[i]);
        }

        return dpi0;
    }

    // leetcode 714 =========================================================================
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            int dpi0_prev = dpi0;
            
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpi0_prev - (prices[i]+fee));
        }

        return dpi0;
    }

    // leetcode 309 =========================================================
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp0 = new int[n];
        int[] dp1 = new int[n];

        for(int i=0; i<n; i++){
            if(i==0){
                dp0[i] = 0;
                dp1[i] = - prices[i]; 
                continue;
            } else if(i==1){
                dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
                dp1[i] = Math.max(dp1[i-1],0-prices[i]);
                continue;
            }

            dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
            dp1[i] = Math.max(dp1[i-1],dp0[i-2]-prices[i]);
        }

        return dp0[n-1];
    }

    // leetcode 309 better =========================================================
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dp_prev_to_prev = 0; // dp0[i-2];
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            int dp_prev = dpi0; // dp0[i-1]
            
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dp_prev_to_prev - prices[i]);

            dp_prev_to_prev=dp_prev; // 
        }

        return dpi0;
    }

    // leetcode 123 =================================================================

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int K=2;

        int[][][] dp = new int[n][K+1][2];

        for(int i=0; i<n; i++){
            for(int k=0; k<=K; k++){
                for(int x=0; x<2; x++){
                    if(k==0){
                        if(x==0){
                            dp[i][k][x]=0;
                        } else {
                            dp[i][k][x]=(int)(-1e9);
                        }
                    } else{
                        if(i==0){
                            if(x==0){
                                dp[i][k][x] = Math.max(0, (int)(-1e9) + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max((int)(-1e9), 0 -prices[i]);
                            }
                        } else {
                            if(x==0){
                                dp[i][k][x] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] -prices[i]);
                            }
                        }
                    }
                }                
            }
        }

        return dp[n-1][K][0];
    }

    // leetcode 123 (better) =================================================================

    public int maxProfit(int[] prices) {
        int dp10 = 0;
        int dp20 = 0;
        int dp11 =-(int)(1e9);
        int dp21 =-(int)(1e9);

        for(int i=0; i<prices.length; i++){
            int p = prices[i];

            dp20 = Math.max(dp20,dp21 + p);
            dp21 = Math.max(dp21,dp10 - p);
            dp10 = Math.max(dp10,dp11 + p);
            dp11 = Math.max(dp11,0 - p);
        }

        return dp20;
    }

    // leetcode 188 (n*k*2 space) =============================================================================
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][K+1][2];

        for(int i=0; i<n; i++){
            for(int k=0; k<=K; k++){
                for(int x=0; x<2; x++){
                    if(k==0){
                        if(x==0){
                            dp[i][k][x]=0;
                        } else {
                            dp[i][k][x]=(int)(-1e9);
                        }
                    } else{
                        if(i==0){
                            if(x==0){
                                dp[i][k][x] = Math.max(0, (int)(-1e9) + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max((int)(-1e9), 0 -prices[i]);
                            }
                        } else {
                            if(x==0){
                                dp[i][k][x] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] -prices[i]);
                            }
                        }
                    }
                }                
            }
        }

        return dp[n-1][K][0];
    }

    // homework => solve leetcode 188 in O(k) space
    public static void main(String[] args) {
        
    }
}

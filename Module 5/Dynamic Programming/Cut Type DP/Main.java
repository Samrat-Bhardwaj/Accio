import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int mcm_rec(int[] arr, int si, int ei){
        if(si+1 == ei){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int cut=si+1; cut<ei; cut++){
            int left = mcm_rec(arr, si, cut);
            int right = mcm_rec(arr, cut, ei);

            int curr_ans = left + arr[si]*arr[cut]*arr[ei] + right;
            ans = Math.min(ans, curr_ans);
        }

        return ans;
    }

    public static int mcm_memo(int[] arr, int si, int ei, int[][] dp){
        if(si+1 == ei){
            return dp[si][ei] = 0;
        }

        if(dp[si][ei]!=0) return dp[si][ei];

        int ans = Integer.MAX_VALUE;
        for(int cut=si+1; cut<ei; cut++){
            int left = mcm_memo(arr, si, cut,dp);
            int right = mcm_memo(arr, cut, ei,dp);

            int curr_ans = left + arr[si]*arr[cut]*arr[ei] + right;
            ans = Math.min(ans, curr_ans);
        }

        return dp[si][ei] = ans;
    }

    public static int mcm_tab(int[] arr, int si, int ei, int[][] dp){
        int n = arr.length;

        for(int diag=1; diag<n; diag++){
            for(si=0, ei=diag; ei<n; si++,ei++){
                if(si+1 == ei){
                    dp[si][ei] = 0;
                    continue;
                }
        
                int ans = Integer.MAX_VALUE;
                for(int cut=si+1; cut<ei; cut++){
                    int left = dp[si][cut]; //mcm_memo(arr, si, cut,dp);
                    int right = dp[cut][ei]; //mcm_memo(arr, cut, ei,dp);
        
                    int curr_ans = left + arr[si]*arr[cut]*arr[ei] + right;
                    ans = Math.min(ans, curr_ans);
                }
        
                dp[si][ei] = ans;
            }
        }

        return dp[0][n-1];
    }

    static int MatrixChainOrder(int arr[], int n) {
        int[][] memo = new int[n][n];

        // return mcm_memo(arr,0,n-1,memo);
        return mcm_tab(arr,0,n-1,memo);
        // return mcm_rec(arr,0,n-1);
    }

    // burst balloons =============================================================
    public int bb_rec(int[] nums, int si, int ei){
        int ans = 0;
        for(int cut=si; cut<=ei; cut++){
            int left = cut==si ? 0 : bb_rec(nums, si, cut-1);
            int right = cut == ei ? 0 : bb_rec(nums, cut+1, ei);

            int myCost = nums[cut];
            if(si-1>=0){
                myCost*=nums[si-1];
            }
            if(ei+1<nums.length){
                myCost*=nums[ei+1];
            }

            int curr_ans = left + right + myCost;
            ans = Math.max(ans,curr_ans);
        }

        return ans;
    }

    public int bb_memo(int[] nums, int si, int ei, int[][] dp){
        if(dp[si][ei]!=0) return dp[si][ei];

        int ans = 0;
        for(int cut=si; cut<=ei; cut++){
            int left = cut==si ? 0 : bb_memo(nums, si, cut-1, dp);
            int right = cut == ei ? 0 : bb_memo(nums, cut+1, ei, dp);

            int myCost = nums[cut];
            if(si-1>=0){
                myCost*=nums[si-1];
            }
            if(ei+1<nums.length){
                myCost*=nums[ei+1];
            }

            int curr_ans = left + right + myCost;
            ans = Math.max(ans,curr_ans);
        }

        return dp[si][ei]=ans;
    }

    public int bb_tab(int[] nums, int[][] dp){
        int n = nums.length;

        for(int diag =0; diag<n; diag++){
            for(int si=0, ei=diag; ei<n; si++,ei++){
                int ans = 0;
                for(int cut=si; cut<=ei; cut++){
                    int left = cut==si ? 0 : dp[si][cut-1]; //bb_memo(nums, si, cut-1, dp);
                    int right = cut == ei ? 0 : dp[cut+1][ei]; //bb_memo(nums, cut+1, ei, dp);

                    int myCost = nums[cut];
                    if(si-1>=0){
                        myCost*=nums[si-1];
                    }
                    if(ei+1<nums.length){
                        myCost*=nums[ei+1];
                    }

                    int curr_ans = left + right + myCost;
                    ans = Math.max(ans,curr_ans);
                }

                dp[si][ei]=ans;
            }
        }

        return dp[0][n-1];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        return bb_tab(nums,memo);
        // return bb_memo(nums,0,n-1,memo);
        // return bb_rec(nums,0,n-1);
    }

    // homework 

    // https://leetcode.com/problems/minimum-cost-to-merge-stones/description/

    // https://leetcode.com/problems/palindrome-partitioning/
    public boolean[][] createIsPallindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int diag=0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // i==j
                    dp[i][j]=true;
                } else if(diag==1){ // i+1 == j
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                    }
                } else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        return dp;
    }

    public void rec(String s, int si, int ei, List<List<String>> ans, List<String> curr,boolean[][] isPall){
        if(si>ei){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int cut=si; cut<=ei; cut++){
            if(isPall[si][cut]){
                curr.add(s.substring(si,cut+1));
                rec(s,cut+1,ei,ans,curr,isPall);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        boolean[][] dp = createIsPallindrome(s); 
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        rec(s,0,s.length()-1,ans,curr,dp);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}

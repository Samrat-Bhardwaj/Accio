import java.util.Arrays;

public class Main {
    public String makePallindromeBoolenDP(String str){
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int si = -1;
        int ei = -1;

        for(int diag = 0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // substrings of size always a pallindromw
                    dp[i][j] = true;
                } else if(diag == 1){ // substrings of size2
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                    }
                } else {
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]; // if substring(i+1,j-1) is not a pallindrome, substring(i,j) is not a pallindrome and vice versa
                    }
                }

                if(dp[i][j]==true){
                    si = i;
                    ei = j;
                }
            }
        }
        return str.substring(si, ei + 1);
    }

    // leetcode 5 ======================================
    public String longestPalindrome(String s) {
        return makePallindromeBoolenDP(s);
    }

    // number of pallindromes ===========================

    // leetcode 647 =========================================================== 
    public static int countSubstrings(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count=0;

        for(int diag = 0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // substrings of size always a pallindromw
                    dp[i][j] = true;
                } else if(diag == 1){ // substrings of size2
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                    }
                } else {
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]; // if substring(i+1,j-1) is not a pallindrome, substring(i,j) is not a pallindrome and vice versa
                    }
                }

                if(dp[i][j]==true){
                    count++;
                }
            }
        }
        return count;
    }

    // longest common subsequence =============================================== 
    public static int rec_lcs(int n, int m, String s1, String s2){
        if(n==0 || m==0){
            return 0;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return rec_lcs(n-1, m-1, s1, s2) + 1;
        } else {
            return Math.max(rec_lcs(n,m-1,s1,s2),rec_lcs(n-1, m, s1, s2));
        }
    }

    public static int rec_memo(int n, int m, String s1, String s2,int[][] dp){
        if(n==0 || m==0){
            return dp[n][m]=0;
        }

        if(dp[n][m]!=-1) return dp[n][m]; 

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = rec_memo(n-1, m-1, s1, s2,dp) + 1;
        } else {
            return dp[n][m] = Math.max(rec_memo(n,m-1,s1,s2,dp),rec_memo(n-1, m, s1, s2,dp));
        }
    }

    public static int lcs_tab(int N, int M, String s1, String s2, int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    dp[n][m]=0;
                    continue;
                }
        
                if(s1.charAt(n-1) == s2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1] + 1; //rec_memo(n-1, m-1, s1, s2,dp) + 1;
                } else {
                    dp[n][m] = Math.max(dp[n][m-1],dp[n-1][m]); //Math.max(rec_memo(n,m-1,s1,s2,dp),rec_memo(n-1, m, s1, s2,dp));
                }
            }
        }

        return dp[N][M];
    }

    static int lcs(int n, int m, String a, String b) {
        int[][] memo = new int[n+1][m+1];
        // for(int[] d:memo){
        //     Arrays.fill(d,-1);
        // }
        // return rec_memo(n,m,a,b,memo);
        // return rec_lcs(n,m,a,b);

        return lcs_tab(n, m, a, b, memo);
    }

    // leetcode 583 ==========================================
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int lcs = lcs(n,m,word1,word2);

        return n + m - 2*lcs;
    }

    // longest pallindromic subsequence =============================
    public static int lps_rec(String str, int i, int j){
        if(i==j){
            return 1;
        }

        if(str.charAt(i)==str.charAt(j)){
            if(i+1 == j){
                return 2;
            } else {
                return lps_rec(str, i+1, j-1) + 2;
            }
        } else {
            return Math.max(lps_rec(str,i,j-1),lps_rec(str, i+1, j));
        }
    }

    public static int lps_memo(String str, int i, int j,int[][] dp){
        if(i==j){
            return dp[i][j] = 1;
        }

        if(dp[i][j]!=0) return dp[i][j];

        if(str.charAt(i)==str.charAt(j)){
            if(i+1 == j){
                return dp[i][j] = 2;
            } else {
                return dp[i][j] = lps_memo(str, i+1, j-1,dp) + 2;
            }
        } else {
            return dp[i][j] = Math.max(lps_memo(str,i,j-1,dp),lps_memo(str, i+1, j,dp));
        }
    }

    public static int lps_tab(String str, int i, int j, int[][] dp){
        int n = str.length();
        for(int diag=0; diag<n; diag++){
            for(i=0,j=diag; j<n; i++,j++){
                if(i==j){
                    dp[i][j] = 1;
                    continue;
                }
        
                if(str.charAt(i)==str.charAt(j)){
                    if(i+1 == j){
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i+1][j-1] + 2;//lps_memo(str, i+1, j-1,dp) + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]); //Math.max(lps_memo(str,i,j-1,dp),lps_memo(str, i+1, j,dp));
                }
            }
        }

        return dp[0][n-1];
    }

    public static int longestPalindromeSubseq(String str) {
        int n = str.length();
        int[][] memo = new int[n][n];
        // return lps_memo(str,0,n-1,memo);
        // return lps_rec(str,0,n-1);
        return lps_tab(str, 0, n-1, memo);
    }


    // longest pallindromic subsequence with String as answer ==========

    public static String lps_tabString(String str, int i, int j, int[][] dp){
        int n = str.length();
        String[][] sdp = new String[n][n];

        for(int diag=0; diag<n; diag++){
            for(i=0,j=diag; j<n; i++,j++){
                if(i==j){
                    dp[i][j] = 1;
                    sdp[i][j] = str.charAt(i)+"";
                    continue;
                }
        
                if(str.charAt(i)==str.charAt(j)){
                    if(i+1 == j){
                        dp[i][j] = 2;
                        sdp[i][j] = str.substring(i, i+2);
                    } else {
                        dp[i][j] = dp[i+1][j-1] + 2;//lps_memo(str, i+1, j-1,dp) + 2;
                        sdp[i][j] = str.charAt(i) + sdp[i+1][j-1] + str.charAt(j);
                    }
                } else {
                    // dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]); //Math.max(lps_memo(str,i,j-1,dp),lps_memo(str, i+1, j,dp));
                    if(dp[i][j-1] > dp[i+1][j]){
                        dp[i][j] = dp[i][j-1];
                        sdp[i][j] = sdp[i][j-1];
                    } else {
                        dp[i][j] = dp[i+1][j];
                        sdp[i][j] = sdp[i+1][j];
                    }
                }
            }
        }

        return sdp[0][n-1];
    }

    String longestPalSubseq(String str){
        int n = str.length();
        int[][] dp = new int[n][n];
        return lps_tabString(str, 0, n-1, dp);
	}

    // minimum insertions to make string pallindrome ============================== 
    public static int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    // leetcode 72 (Edit distance )
    public int minDistance_rec(int n, int m, String w1, String w2){
        if(n==0 || m==0){
            return n==0 ? m : n;
        }

        if(w1.charAt(n-1) == w2.charAt(m-1)){
            return minDistance_rec(n-1,m-1,w1, w2);
        } else {
            int replace = minDistance_rec(n-1, m-1, w1, w2);
            int delete = minDistance_rec(n-1, m, w1, w2);
            int insert = minDistance_rec(n, m-1, w1, w2);

            return Math.min(replace,Math.min(delete,insert)) + 1;
        }

    }

    public int minDistance_memo(int n, int m, String w1, String w2,int[][] dp){
        if(n==0 || m==0){
            return dp[n][m] = n==0 ? m : n;
        }

        if(dp[n][m]!=-1) return dp[n][m];

        if(w1.charAt(n-1) == w2.charAt(m-1)){
            return dp[n][m] = minDistance_memo(n-1,m-1,w1, w2,dp);
        } else {
            int replace = minDistance_memo(n-1, m-1, w1, w2,dp);
            int delete = minDistance_memo(n-1, m, w1, w2,dp);
            int insert = minDistance_memo(n, m-1, w1, w2,dp);

            return dp[n][m] = Math.min(replace,Math.min(delete,insert)) + 1;
        }
    }

    public int minDistance_tab(int N, int M, String w1, String w2,int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    dp[n][m] = n==0 ? m : n;
                    continue;
                }
        
                if(w1.charAt(n-1) == w2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1]; //minDistance_memo(n-1,m-1,w1, w2,dp);
                } else {
                    int replace = dp[n-1][m-1]; //minDistance_memo(n-1, m-1, w1, w2,dp);
                    int delete = dp[n-1][m]; //minDistance_memo(n-1, m, w1, w2,dp);
                    int insert = dp[n][m-1]; //minDistance_memo(n, m-1, w1, w2,dp);
        
                    dp[n][m] = Math.min(replace,Math.min(delete,insert)) + 1;
                }
            }
        }

        return dp[N][M];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] memo = new int[n+1][m+1];
        return minDistance_tab(n, m, word1, word2, memo);
        // for(int[] d:memo){
        //     Arrays.fill(d,-1);
        // }
        // return minDistance_memo(n, m,word1,word2,memo);
        // return minDistance_rec(n, m,word1,word2);
    }

    // leetcode 115 =================================================
    public int distinctSubs_rec(int n, int m, String s, String t){
        if(n<m){
            return 0;
        }
        if(m==0){
            return 1;
        }

        if(s.charAt(n-1)!=t.charAt(m-1)){
            return distinctSubs_rec(n-1, m, s, t);
        } else {
            return distinctSubs_rec(n-1, m-1, s, t) + distinctSubs_rec(n-1, m, s, t);
        }
    }

    public int distinctSubs_memo(int n, int m, String s, String t,int[][] dp){
        if(n<m){
            return dp[n][m] = 0;
        }
        if(m==0){
            return dp[n][m] = 1;
        }

        if(dp[n][m]!=-1) return dp[n][m];

        if(s.charAt(n-1)!=t.charAt(m-1)){
            return dp[n][m] = distinctSubs_memo(n-1, m, s, t,dp);
        } else {
            return dp[n][m] = distinctSubs_memo(n-1, m-1, s, t,dp) + distinctSubs_memo(n-1, m, s, t,dp);
        }
    }

    public int distinctSubs_tab(int N, int M, String s, String t,int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n<m){
                    dp[n][m] = 0;
                    continue;
                }
                if(m==0){
                    dp[n][m] = 1;
                    continue;
                }
        
                if(s.charAt(n-1)!=t.charAt(m-1)){
                    dp[n][m] = dp[n-1][m]; //distinctSubs_memo(n-1, m, s, t,dp);
                } else {
                    dp[n][m] = dp[n-1][m-1] + dp[n-1][m]; //distinctSubs_memo(n-1, m-1, s, t,dp) + distinctSubs_memo(n-1, m, s, t,dp);
                }
            }
        }

        return dp[N][M];
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] memo = new int[n+1][m+1];
        return distinctSubs_tab(n, m, s, t, memo);
        // for(int[] d:memo){
        //     Arrays.fill(d,-1);
        // }
        // return distinctSubs_memo(n,m,s,t,memo);
        // return distinctSubs_rec(n,m,s,t);
    }

    // homework =========================================================
    // https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    
    // https://course.acciojob.com/idle?question=eaebd540-75c3-4284-91de-5c798a8f4bf5
    public static int fun(String s)
    {
        long ewa = 0;
        long ewb = 0;
        long ewc = 0;

		long mod=(long)1e9+7;

		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='a'){
				ewa = 2*ewa + 1;
			} else if(s.charAt(i)=='b'){
				ewb = 2*ewb + ewa;
			} else if(s.charAt(i)=='c'){
				ewc = 2*ewc + ewb;
			}

			ewa = ewa%mod;
			ewb = ewb%mod;
			ewc = ewc%mod;
		}

		return (int)(ewc%mod);
    }

    // leetcode 44 ====================================================================================

    public boolean wildCard_rec(int n, int m, String s, String p){
        if(n==0 || m==0){
            if(n==0 && m==0){
                return true;
            } else if(m==1 && p.charAt(m-1)=='*'){
                return true;
            } else {
                return false;
            }
        }

        if(p.charAt(m-1)=='?'){
            return wildCard_rec(n-1, m-1, s, p);
        } else if(p.charAt(m-1)=='*'){
            return wildCard_rec(n-1, m, s, p) || wildCard_rec(n, m-1, s, p);
        } else if(s.charAt(n-1) == p.charAt(m-1)){
            return wildCard_rec(n-1, m-1, s, p);
        } else {
            return false;
        }
    }

    public int wildCard_memo(int n, int m, String s, String p,int[][] dp){
        if(n==0 || m==0){
            if(n==0 && m==0){
                return dp[n][m] = 1;
            } else if(m==1 && p.charAt(m-1)=='*'){
                return dp[n][m] = 1;
            } else {
                return dp[n][m] = 0;
            }
        }

        if(dp[n][m]!=-1) return dp[n][m];

        if(p.charAt(m-1)=='?'){
            return dp[n][m] = wildCard_memo(n-1, m-1, s, p,dp);
        } else if(p.charAt(m-1)=='*'){
            return dp[n][m] = wildCard_memo(n-1, m, s, p,dp) | wildCard_memo(n, m-1, s, p,dp);
        } else if(s.charAt(n-1) == p.charAt(m-1)){
            return dp[n][m] = wildCard_memo(n-1, m-1, s, p,dp);
        } else {
            return dp[n][m] = 0;
        }
    }

    public int wildCard_tab(int N, int M, String s, String p, int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    if(n==0 && m==0){
                        dp[n][m] = 1;
                    } else if(m==1 && p.charAt(m-1)=='*'){
                        dp[n][m] = 1;
                    } else {
                        dp[n][m] = 0;
                    }
                    continue;
                }
        
                if(p.charAt(m-1)=='?'){
                    dp[n][m] = dp[n-1][m-1]; //wildCard_memo(n-1, m-1, s, p,dp);
                } else if(p.charAt(m-1)=='*'){
                    dp[n][m] = dp[n-1][m] | dp[n][m-1]; //wildCard_memo(n-1, m, s, p,dp) | wildCard_memo(n, m-1, s, p,dp);
                } else if(s.charAt(n-1) == p.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1]; //wildCard_memo(n-1, m-1, s, p,dp);
                } else {
                    dp[n][m] = 0;
                }
            }
        }

        return dp[N][M];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];

        for(int[] d:dp){
            Arrays.fill(d,-1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m;){
            if(p.charAt(i)=='*'){
                sb.append("*");
                while(i<m && p.charAt(i)=='*') i++;
            } else {
                sb.append(p.charAt(i));
                i++;
            }
        }

        p=sb.toString();
        m=p.length();

        return wildCard_tab(n, m, s, p, dp) == 1 ? true : false; 
        // return wildCard_memo(n,m,s,p,dp) == 1 ? true : false;
        // return wildCard_rec(n,m,s,p);
    }

    public static void main(String[] args) {
        
    }
}

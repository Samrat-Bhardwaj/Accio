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
    public static void main(String[] args) {
        
    }
}

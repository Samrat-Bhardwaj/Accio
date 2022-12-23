public class Main {
    // leetcode 1277 ================================================================================
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]==1){
                    int left = matrix[i][j-1];
                    int top = matrix[i-1][j];
                    int topLeft = matrix[i-1][j-1];

                    matrix[i][j] = Math.min(left,Math.min(top,topLeft)) + 1;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans+=matrix[i][j];
            }
        }

        return ans;
    }

    // https://course.acciojob.com/idle?question=8c12622a-4647-420e-8cab-b6341a3fc069
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = matrix[i][j] - '0';
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(dp[i][j]==1){
                    int left = dp[i][j-1];
                    int top = dp[i-1][j];
                    int topLeft = dp[i-1][j-1];

                    dp[i][j] = Math.min(left,Math.min(top,topLeft)) + 1;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }

        return ans*ans;
    }
    public static void main(String[] args) {
        
    }
}

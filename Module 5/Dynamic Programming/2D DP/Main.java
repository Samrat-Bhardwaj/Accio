import java.util.Arrays;

public class Main {

    // https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public static int getMax_rec(int[][] mine, int i, int j){
        if(j==mine[0].length-1){
            return mine[i][j];
        }

        int up = 0;
        int same = 0;
        int down = 0;

        if(i-1 >= 0){
            up = getMax_rec(mine, i-1, j+1);
        }

        same = getMax_rec(mine, i, j+1);

        if(i+1<mine.length){
            down = getMax_rec(mine, i+1, j+1);
        }

        int ans = mine[i][j] + Math.max(up,Math.max(same,down));

        return ans;
    }

    public static int getMax_memo(int[][] mine, int i, int j, int[][] dp){
        if(j==mine[0].length-1){
            return dp[i][j] = mine[i][j];
        }

        if(dp[i][j]!=0) return dp[i][j];

        int up = 0;
        int same = 0;
        int down = 0;

        if(i-1 >= 0){
            up = getMax_memo(mine, i-1, j+1,dp);
        }

        same = getMax_memo(mine, i, j+1,dp);

        if(i+1<mine.length){
            down = getMax_memo(mine, i+1, j+1,dp);
        }

        int ans = mine[i][j] + Math.max(up,Math.max(same,down));

        return dp[i][j] = ans;
    }

    public static int goldmine_tab(int[][] mine, int[][] dp){
        for(int j = mine[0].length-1; j>=0; j--){
            for(int i=0; i<mine.length; i++){
                if(j==mine[0].length-1){
                    dp[i][j] = mine[i][j];
                    continue;
                }
        
                int up = 0;
                int same = 0;
                int down = 0;
        
                if(i-1 >= 0){
                    up = dp[i-1][j+1]; //getMax_memo(mine, i-1, j+1,dp);
                }
        
                same = dp[i][j+1];//getMax_memo(mine, i, j+1,dp);
        
                if(i+1<mine.length){
                    down = dp[i+1][j+1]; //getMax_memo(mine, i+1, j+1,dp);
                }
        
                int ans = mine[i][j] + Math.max(up,Math.max(same,down));
        
                dp[i][j] = ans;
            }
        }

        int ans = 0;
        for(int i=0; i<mine.length; i++){
            ans = Math.max(ans,dp[i][0]);
        }

        return ans;
    }

    static int maxGold(int n, int m, int M[][])
    {
        // int ans = 0;
        int[][] dp = new int[n][m];
        // for(int i=0; i<n; i++){
        //     int gold = getMax_rec(M,i,0);
        //     ans = Math.max(gold,ans);
        // }

        // for(int i=0; i<n; i++){
        //     int gold = getMax_memo(M,i,0,dp);
        //     ans = Math.max(gold,ans);
        // }

        // return ans;

        return goldmine_tab(M, dp);
    }

    // leetcode 64 ==============================================
    public int minPath_rec(int[][] grid, int i, int j){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }

        int right = Integer.MAX_VALUE;
        int down  = Integer.MAX_VALUE;

        if(j+1 < grid[0].length){
            right = minPath_rec(grid, i, j+1);
        }

        if(i+1 < grid.length){
            down = minPath_rec(grid, i+1, j);
        }

        int ans = grid[i][j] + Math.min(right,down);

        return ans;
    }

    public int minPath_memo(int[][] grid, int i, int j, int[][] dp){
        if(i==grid.length-1 && j==grid[0].length-1){
            return dp[i][j] = grid[i][j];
        }

        if(dp[i][j]!=0) return dp[i][j];

        int right = Integer.MAX_VALUE;
        int down  = Integer.MAX_VALUE;

        if(j+1 < grid[0].length){
            right = minPath_memo(grid, i, j+1, dp);
        }

        if(i+1 < grid.length){
            down = minPath_memo(grid, i+1, j, dp);
        }

        int ans = grid[i][j] + Math.min(right,down);

        return dp[i][j] = ans;
    }

    public int minPath_tab(int[][] grid, int i, int j, int[][] dp){
        for(i=grid.length-1; i>=0; i--){
            for(j=grid[0].length-1; j>=0; j--){
                if(i==grid.length-1 && j==grid[0].length-1){
                    dp[i][j] = grid[i][j];
                    continue;
                }
        
                int right = Integer.MAX_VALUE;
                int down  = Integer.MAX_VALUE;
        
                if(j+1 < grid[0].length){
                    right = dp[i][j+1];//minPath_memo(grid, i, j+1, dp);
                }
        
                if(i+1 < grid.length){
                    down = dp[i+1][j];  //minPath_memo(grid, i+1, j, dp);
                }
        
                int ans = grid[i][j] + Math.min(right,down);
        
                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }

    public int minPath_tabString(int[][] grid, int i, int j, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        String[][] sdp = new String[n][m];

        for(i=grid.length-1; i>=0; i--){
            for(j=grid[0].length-1; j>=0; j--){
                if(i==grid.length-1 && j==grid[0].length-1){
                    dp[i][j] = grid[i][j];
                    sdp[i][j] = "";
                    continue;
                }
        
                int right = Integer.MAX_VALUE;
                int down  = Integer.MAX_VALUE;
        
                if(j+1 < grid[0].length){
                    right = dp[i][j+1];//minPath_memo(grid, i, j+1, dp);
                }
        
                if(i+1 < grid.length){
                    down = dp[i+1][j];  //minPath_memo(grid, i+1, j, dp);
                }
        
                int ans = grid[i][j];

                if(right < down){
                    ans += right;
                    sdp[i][j] = "r" + sdp[i][j+1];
                } else {
                    ans += down;
                    sdp[i][j] = "d" + sdp[i+1][j];
                }

                dp[i][j] = ans;
            }
        }

        System.out.println(sdp[0][0]);
        return dp[0][0];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        // return minPath_rec(grid,0,0);
        return minPath_tab(grid, 0, 0, dp);
    }

    // target sum subset
    public static boolean isSubsetSum_rec(int idx, int[] arr, int target){
        if(target == 0){
            return true;
        }

        if(idx == arr.length){
            return false;
        }

        boolean pick = false;

        if(target - arr[idx] >=0)
            pick = isSubsetSum_rec(idx+1, arr, target-arr[idx]);

        boolean notPick = isSubsetSum_rec(idx+1, arr, target);

        return pick || notPick ;
    }

    public static int isSubsetSum_memo(int idx, int[] arr, int target, int[][] dp){
        if(target == 0){
            return dp[idx][target] = 1;
        }

        if(idx == arr.length){
            return dp[idx][target] = 0; 
        }

        if(dp[idx][target]!=-1) return dp[idx][target];

        int pick = 0;

        if(target - arr[idx] >=0)
            pick = isSubsetSum_memo(idx+1, arr, target-arr[idx], dp);

        int notPick = isSubsetSum_memo(idx+1, arr, target, dp);

        return dp[idx][target] = pick | notPick ;
    }

    public static boolean isSubsetSum_tab(int idx, int[] arr, int Target, boolean[][] dp){
        for(idx = arr.length; idx>=0; idx--){
            for(int target = 0; target<=Target; target++){
                if(target == 0){
                    dp[idx][target] = true;
                    continue;
                }
        
                if(idx == arr.length){
                    dp[idx][target] = false; 
                    continue;
                }
        
                boolean pick = false;
        
                if(target - arr[idx] >=0)
                    pick = dp[idx+1][target-arr[idx]]; //isSubsetSum_memo(idx+1, arr, target-arr[idx], dp);
        
                boolean notPick = dp[idx+1][target];  //isSubsetSum_memo(idx+1, arr, target, dp);
        
                dp[idx][target] = pick | notPick ;
            }
        }

        return dp[0][Target];
    }

    static Boolean isSubsetSum(int N, int arr[], int target){
        // int[][] dp = new int[N+1][target+1];
        // for(int[] d:dp){
        //     Arrays.fill(d,-1);
        // }
        // return isSubsetSum_rec(0, arr, target);
        // int ans =  isSubsetSum_memo(0, arr, target,dp);
        // return ans == 1  ? true : false;
        return isSubsetSum_tab(0, arr, target, new boolean[N+1][target+1]);
    }

    // homework 
    // https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
    public static void main(String[] args) {
        
    }
}

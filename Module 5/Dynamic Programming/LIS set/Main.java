import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // leetcode 300 ===================================
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i]=1;

            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){ // is addition of ith point possible after jth point 
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public int maxSumIS(int nums[], int n)  {  
        int[] dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i]=nums[i];

            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){ // is addition of ith point possible after jth point 
                    dp[i] = Math.max(dp[i],dp[j]+nums[i]);
                }
            }

            ans = Math.max(ans,dp[i]);
        }

        return ans;
	} 

    // leetcode 673 ================================================= 

    public int findNumberOfLIS(int[] nums) {
        int n= nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLength = 0;
        int maxCount = 0; 

        for(int i=0; i<n; i++){
            dp[i] = 1;
            count[i] = 1;
            
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    } else if(dp[i] == dp[j]+1){
                        count[i] += count[j];
                    }
                }
            }

            if(dp[i] > maxLength){
                maxLength = dp[i];
                maxCount = count[i];
            } else if(dp[i] == maxLength){
                maxCount += count[i];
            }
        }

        return maxCount;
    }

    // longest bitonic subsequence ======================================
    public void findLIS(int[] nums, int[] dp, int n){
        
        for(int i=0; i<n; i++){
            dp[i]=1;

            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){ // is addition of ith point possible after jth point 
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
    }

    public void findLDS(int[] nums, int[] dp, int n){
        
        for(int i=n-1; i>=0; i--){
            dp[i]=1;

            for(int j=i+1; j<n; j++){
                if(nums[i] > nums[j]){ 
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

    }
    public int LongestBitonicSequence(int[] nums){
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        findLIS(nums,lis,n);
        findLDS(nums,lds,n);

        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans,lis[i]+lds[i]-1);
        }

        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/minimum-insertions-to-sort-an-array0535/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i]=1;

            for(int j=i-1; j>=0; j--){
                if(nums[i] >= nums[j]){ // is addition of ith point possible after jth point 
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
    public int minInsertions(int arr[], int N) { 
        int lis = lengthOfLIS2(arr);

        return N - lis;
	} 

    // LIS Better =============================================================
    public int findPos(ArrayList<Integer> dp, int ele){
        int left = 0;
        int right = dp.size() - 1;

        while(left <= right){
            int mid = (left+right)/2;

            if(dp.get(mid) < ele){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int lengthOfLIS_(int[] nums) {
        int n = nums.length;
        
        ArrayList<Integer> dp = new ArrayList<>();

        for(int i=0; i<n; i++){
            int pos = findPos(dp,nums[i]);

            if(pos==dp.size()){
                dp.add(nums[i]);
            } else {
                dp.set(pos,nums[i]);
            }
        }

        return dp.size();
    }

    // https://www.geeksforgeeks.org/dynamic-programming-building-bridges/

    public static int maxNonOverlappingBridges(int[][] bridges){
        Arrays.sort(bridges,(int[] t, int[] o)->{
            return t[0] - o[0];
        });

        int n = bridges.length;
        int[] dp = new int[n];
        int ans=0;

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(bridges[i][1] > bridges[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }

            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    // russian doll envelopes ================================================== 
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (t, o)->{
            return t[0] - o[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        int ans=0;

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            ans=Math.max(ans,dp[i]);
        }

        return ans;
    }

    // russian doll Better (O(NlogN)) ============
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (t, o)->{
            if(t[0] == o[0]){ // if width is equal then larger height should be on top 
                return o[1] - t[1];
            }
            return t[0] - o[0];
        });

        int n = envelopes.length;
        ArrayList<Integer> dp = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h = envelopes[i][1];

            int pos = findPos(dp, h);
            if(pos==dp.size()){
                dp.add(h);
            } else {
                dp.set(pos,h);
            }
        }

        return dp.size();
    }

    // leetcode 1691 ==================================================== 
    // box stacking

    public int maxHeight(int[][] cuboids) {
        for(int[] cuboid:cuboids){
            Arrays.sort(cuboid); // so that my height is maximum
        }

        int n = cuboids.length;
        Arrays.sort(cuboids,(t,o)->{
            if(t[0]!=o[0]){ // if width not equal, smaller width previous 
                return t[0] - o[0];
            }

            if(t[1]!=o[1]){ // width equal, if lenght, smaller length before
                return t[1] - o[1];
            }

            return t[2] - o[2]; // width equal, length equal, sort on the basis of height
        });

        int[] dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i] = cuboids[i][2]; // height

            for(int j=i-1; j>=0; j--){
                if(cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]){
                    dp[i] = Math.max(dp[j]+cuboids[i][2],dp[i]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] bridges = {{6,2},{4,3},{2,6},{1,5}};
        System.out.println(maxNonOverlappingBridges(bridges));
    }
}

public class Questions {
    // leetcode 1 =========================================================
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{};
    }

    // leetcode 167 =============================================================
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        int i=0; 
        int j=n-1;
        
        while(i<j){
            int csum = nums[i] + nums[j];
            
            if(csum < target){
                i++;
            } else if(csum > target){
                j--;
            } else {
                return new int[]{i+1,j+1};
            }
        }
        
        return new int[]{};
    }

    public static int diffPossible(int[] nums, int tar) {
        int n=nums.length;

        int i=0;
        int j=1;

        while(i<n && j<n){
            int diff = nums[j] - nums[i];

            if(diff < tar){
                j++;
            } else if(diff> tar){
                i++;
            } else {
                if(i!=j){
                    return 1; // returning true, pair is {i,j};
                } else { // i==j, diff = 0 
                    j++;
                }
            }
        }

        return 0; // returning false, didn't find any sol
    }

    // leetcode 11 ==================================================================
    public int maxArea(int[] height) {
        int n=height.length;
        
        int ans = 0;
        int i=0;
        int j=n-1;
        
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int w = j - i;
            
            int currArea = h*w;
            if(currArea > ans){
                ans = currArea; // getting a new maximum
            }
            
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        
    }
}

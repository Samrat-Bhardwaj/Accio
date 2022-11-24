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

    // https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    void segregate0and1(int[] arr, int n) {
        int zeros = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                zeros++;
            }
        }
        
        
        int i=0;
        while(i<zeros){
            arr[i]=0;
            i++;
        }
        
        while(i<n){
            arr[i]=1;
            i++;
        }
    }

    // in one iteration using areas 

    // {0,i-1} => all the zeros
    // {i,j} => undiscovered
    // {j+1,n-1} => all the ones
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void segregate0and1(int[] arr, int n) {
        int i=0;
        int j=n-1;
        
        while(i<=j){
            if(arr[i]==1){
                swap(arr,i,j);
                j--;
            } else {
                i++;
            }
        }
    }

    // leetcode 75 ===================================================
    public void sortColors(int[] nums) {
        int n=nums.length;
        
        int p1 = -1;
        int p2 = 0;
        int p3 = n-1;
        
        while(p2<=p3){ // until undiscovered area is not finish
            if(nums[p2]==2){
                swap(nums,p2,p3);
                p3--;
            } else if(nums[p2]==0){
                p1++;
                swap(nums,p1,p2);
                p2++;
            } else {
                p2++;
            }
        }
    }

    // homework
    
    // https://course.acciojob.com/idle?question=0579040b-f013-4c85-988a-07130a995397
    // move zeros to the end from leetcode 
    public static void main(String[] args) {
        
    }
}

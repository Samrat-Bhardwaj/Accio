import java.util.ArrayList;

class Contest1 {
    // https://course.acciojob.com/idle?question=b8ed4c6a-e4ab-4d31-968d-4696b1686557
    int ans = 0; 
	public void getAllXor(int[] nums, int idx, int cxor){
		if(idx==nums.length){
			ans += cxor;
			return;
		}

		getAllXor(nums,idx+1,cxor^nums[idx]);
		getAllXor(nums,idx+1,cxor);
	}
    public int sumOfAccioScores(int[] nums) {
        ans = 0;
		getAllXor(nums,0,0);
		return ans;
    }


    class Solution{
        public static int minAbsoluteDiff(int[] arr, int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,int soset2){
            if(idx==arr.length){
                int n = arr.length;
                if(n%2 ==0 && set1.size()==set2.size()){
                    return Math.abs(soset1 - soset2);
                } else if(n%2==1 && Math.abs(set1.size()-set2.size())==1){
                    return Math.abs(soset1 - soset2);
                }

                return Integer.MAX_VALUE;
            }

            set1.add(arr[idx]);
            int ans1 = minAbsoluteDiff(arr, idx + 1, set1, set2, soset1+arr[idx], soset2);
            set1.remove(set1.size()-1);

            set2.add(arr[idx]);
            int ans2 = minAbsoluteDiff(arr, idx + 1, set1, set2, soset1, soset2+arr[idx]);
            set2.remove(set2.size()-1);

            return Math.min(ans1,ans2);
        }
    }

    // https://course.acciojob.com/idle?question=caa4e30e-feae-4685-ba03-aeeb5faf8721
    public static int floodfill(int[][] arr, int n,boolean[][] visited, int i, int j){
        if(i<0 || j<0 || i>=n || j>=n || arr[i][j]==0 || visited[i][j]==true){
            return 0;
        }

        if(i==n-1 && j==n-1){
            return 1;
        }

        int ans =0;

        visited[i][j]=true;
        ans+=floodfill(arr, n, visited, i + 1, j);
        ans+=floodfill(arr, n, visited, i - 1, j);
        ans+=floodfill(arr, n, visited, i, j + 1);
        ans+=floodfill(arr, n, visited, i, j - 1);
        visited[i][j]=false;

        return ans;
    }

    public static int totalPossibleWays(int[][] arr, int n) {
        boolean[][] visited = new boolean[n][n];

        return floodfill(arr,n,visited,0,0);
    }
    public static void main(String[] args) {
        
    }
}
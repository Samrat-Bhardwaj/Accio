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
    
    static int MatrixChainOrder(int arr[], int n) {
        return mcm_rec(arr,0,n-1);
    }
    public static void main(String[] args) {
        
    }
}

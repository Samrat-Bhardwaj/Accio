public class ContestDiscussion2 {
    // https://course.acciojob.com/idle?question=f2ab38ff-370b-4417-9bc6-97ece3b4cf1f
    public boolean isMagical(int n, int itrNum){
        if(itrNum > n){
            return true;
        }
        if(n % itrNum == 0){
            return false;
        }

        int next_pos = n - (n/itrNum);
        return isMagical(next_pos, itrNum + 1);
    }

    public boolean solve(int n) {
        return isMagical(n,2);
    }

    // leetcode 486, https://course.acciojob.com/idle?question=b4dfaf91-ed01-447d-b3bc-a34a30b5c38e
    public int findMax(int[] arr, int i, int j){
        if(i>j){
            return 0;
        }

        int firstElement = arr[i] + Math.min(findMax(arr,i+2,j), findMax(arr, i+1, j-1));
        int lastElement = arr[j] + Math.min(findMax(arr,i+1,j-1), findMax(arr, i, j-2));

        int ans = Math.max(firstElement, lastElement);
        return ans;
    }

    public boolean solve(int n,int arr[])
    {
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        int alexScore = findMax(arr,0,n-1);
        int aliceScore = sum - alexScore;

        if(alexScore>=aliceScore){
            return true;
        } else {
            return false;
        }
        // return alexScore >= aliceScore;
    }

    // leetcode 390, https://course.acciojob.com/idle?question=f0c7ce37-b542-44c2-ad19-95f824a16af0
    public int solve_rec(int start, int diff, boolean left, int noe){
        if(noe==1){
            return start;
        }

        if(left == true){
            start = start + diff;
            return solve_rec(start, diff*2, false, noe/2);
        } else {
            if(noe%2!=0){
                start = start+diff;
            }
            return solve_rec(start, diff*2, true, noe/2);
        }
    }
    public int solve(int n){
       return solve_rec(1,1,true,n);
    }
    public static void main(String[] args) {
        
    }
}

public class Questions {

    public static void printArray(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }

        System.out.println(arr[idx]);
        printArray(arr, idx+1);
    }

    public static void printReverse(int[] arr, int idx){
        if(idx==arr.length){
            return;
        }
        printReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }

    public static int maxofArray(int[] arr, int idx){
        if(idx == arr.length){
            return Integer.MIN_VALUE;
        }

        int smallAns = maxofArray(arr, idx+1);

        int ans = Math.max(arr[idx],smallAns);
        return ans;
    }

    public static int firstIndex(int[] arr, int idx, int tar){
        if(idx==arr.length){
            return -1;
        }

        int smallAns = firstIndex(arr, idx+1, tar);
        int ans = 0;

        if(arr[idx] == tar){
            ans = idx;
        } else {
            ans = smallAns;
        }

        return ans;
    }

    public static int lastIndex(int[] arr, int idx, int tar){
        if(idx == arr.length){
            return -1;
        }

        int smallAns = lastIndex(arr, idx+1, tar); 

        int ans = 0;
        if(smallAns == -1){
            if(arr[idx]==tar){
                ans = idx;
            } else {
                ans = smallAns;
            }
        } else {
            ans = smallAns;
        }

        return ans;
    }

    public static int[] allIndices(int[] arr, int idx,int tar, int count){
        if(idx==arr.length){
            int[] ba = new int[count];
            return ba; 
        }

        int[] ans;
        if(arr[idx]==tar){
            ans = allIndices(arr, idx+1, tar, count+1);
        } else {
            ans = allIndices(arr, idx+1, tar, count);
        }

        if(arr[idx]==tar){
            ans[count] = idx;
        }

        return ans;
    }

    // check for pallindrome 
    public static boolean isPalindromic(int[] arr, int si, int ei) {
        if(si>ei){
            return true;
        }

        if(arr[si]!=arr[ei]){
            return false;
        }

        boolean ans = isPalindromic(arr, si + 1, ei - 1);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {9,3,7,3,3,5,3,6};
        int[] ans = allIndices(arr, 0, 3, 0);

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}

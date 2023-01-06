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
    public static void main(String[] args) {
        int[] arr = {10,9,4,11,20};
        System.out.println(maxofArray(arr,0));
    }
}

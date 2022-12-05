public class Main {
    // print array recursively =======================================
    public static void printArray(int idx, int[] arr){
        if(idx == arr.length){
            return;
        }

        System.out.println(arr[idx]);
        printArray(idx+1, arr);
    }

    // print array in reverse recursively ====================================
    public static void printArrayReverse(int idx, int[] arr){
        if(idx==arr.length){
            return;
        }

        printArrayReverse(idx+1, arr);
        System.out.println(arr[idx]);
    }

    public static void fun(int i, int a){
        if(i>4){
            return;
        }

        a = a + 1;
        fun(i+1,a);
    }

    public static int maxOfArray(int idx, int[] arr){
        if(idx==arr.length){
            return 0;
        }

        int sAns = maxOfArray(idx+1, arr);
        int ans=Math.max(arr[idx],sAns);

        return ans;
    };

    public static int maxOfArray2(int idx, int[] arr){
        if(idx==arr.length){
            return 0;
        }
        
        int sAns = maxOfArray2(idx+1, arr);
        if(sAns > arr[idx]){
            return sAns;
        } else {
            return arr[idx];
        }
    };

    public static int firstIndex(int idx, int[] arr, int tar){
        if(idx == arr.length){
            return -1;
        }

        int sAns = firstIndex(idx+1, arr, tar);
        int ans = 0;
        if(arr[idx] == tar){
            ans = idx;
        } else {
            ans = sAns;
        }

        return ans;
    }

    public static int lastIndex(int idx, int[] arr, int tar){
        if(idx == arr.length){
            return -1;
        }

        int sAns = lastIndex(idx+1, arr, tar);
        int ans=0;

        if(sAns == -1){
            if(arr[idx]==tar){
                ans = idx;
            } else {
                ans = -1;
            }
        } else {
            ans = sAns;
        }

        return ans;
    }

    public static int[] allIndices(int idx, int[] arr, int tar, int count){
        if(idx == arr.length){
            int[] ba = new int[count];
            return ba;
        }

        int[] ans;
        if(arr[idx]==tar){
            ans = allIndices(idx+1, arr, tar, count+1);
        } else {
            ans = allIndices(idx+1, arr, tar, count);
        }

        if(arr[idx] == tar){
            ans[count] = idx;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={7,3,3,0,3,4};
        int[] ans = allIndices(0, arr,3,0);
        
        for(int i=0;  i<ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}

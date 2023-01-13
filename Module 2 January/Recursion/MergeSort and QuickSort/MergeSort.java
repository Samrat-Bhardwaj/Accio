class MergeSort {
    public static int[] merge2SortedArrays(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;

        int[] ans = new int[n+m];

        int i=0;
        int j=0;
        int k=0;
        int ei1 = n-1; // ei for arr1
        int ei2 = m-1; // ei for arr2

        while(i<=ei1 && j<=ei2){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
            } else {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i<=ei1){
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while(j<=ei2){
            ans[k] = arr2[j];
            j++;
            k++;
        }

        return ans;
    }

    public static void mergeSortedArrays(int[] arr, int si, int mid, int ei){
        int i = si;
        int j = mid + 1;
        int k = 0;
        int ei1 = mid;
        int ei2 = ei;

        int[] ans = new int[ei - si + 1];

        while(i<=ei1 && j<=ei2){
            if(arr[i] < arr[j]){
                ans[k] = arr[i];
                i++;
            } else {
                ans[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=ei1){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j<=ei2){
            ans[k] = arr[j];
            j++;
            k++;
        }


        k=0;
        for(int idx = si; idx<=ei; idx++,k++){
            arr[idx] = ans[k];
        }
    }

    public static void mergeSort(int[] arr, int si, int ei){
        if(si==ei){
            return;
        }

        int mid = (si + ei)/2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        mergeSortedArrays(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        // int[] arr1 = {1,2,13,19,20,23,24};
        // int[] arr2 = {3,4,11,21};

        // int[] ans = merge2SortedArrays(arr1, arr2);
        // for(int i=0; i<ans.length; i++){
        //     System.out.print(ans[i]+" ");
        // }
        int[] arr = {4,1,3,9,7};

        mergeSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
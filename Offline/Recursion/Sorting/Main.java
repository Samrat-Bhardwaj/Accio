class Main {
    public static int[] merge2sortedArray(int[] nums1, int n, int[] nums2, int m){
        int[] ans = new int[n+m];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                ans[k] = nums1[i];
                i++;
            } else {
                ans[k] = nums2[j];
                j++;
            }

            k++;
        }

        while(i < n){
            ans[k] = nums1[i];
            i++;
            k++;
        }

        while(j < m){
            ans[k] = nums2[j];
            j++;
            k++;
        }

        return ans;
    }

    // MERGE SORT =================================================================
    public static void mergeSortedArrays(int[] arr, int left, int mid, int right){
        int n = mid - left + 1;
        int m = right - mid;

        int[] nums1 = new int[n];
        int[] nums2 = new int[m];

        int curr_idx = left;
        for(int i=0; i<n; i++){
            nums1[i] = arr[curr_idx];
            curr_idx++;
        }

        curr_idx = mid + 1;
        for(int i=0; i<m; i++){
            nums2[i] = arr[curr_idx];
            curr_idx++;
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<n){
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while(j<m){
            arr[k] = nums2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int mid = (left + right)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        // {left,mid} {mid+1, right} -> merge
        mergeSortedArrays(arr,left,mid,right);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // {0,i} -> smaller than pivot
    // {i+1,j-1} -> greater than pivot
    // {j,end} -> unknown area
    public int[] pivotArray(int[] nums, int pivot) {
        int i = -1;
        int j = 0;

        while(j < nums.length){
            if(nums[j] <= pivot){
                i++;
                swap(nums,i,j);
                j++; 
            } else {
                j++;
            }
        }

        return nums;
    }
    
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];

        int i = left - 1;
        int j = left;

        while(j < right){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
                j++; 
            } else {
                j++;
            }
        }

        swap(arr, i+1, right);

        return (i+1);
    }
    
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int partitionIdx = partition(arr,left,right);

        quickSort(arr,left,partitionIdx - 1);
        quickSort(arr,partitionIdx+1,right);
    }

    public static void main(String[] args){
        int[] arr = {10,1,4,9,7,11,2};

        quickSort(arr,0,6);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
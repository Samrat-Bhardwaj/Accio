import java.util.Arrays;
public class QuickSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void partition(int[] arr, int pivot){
        int i=0;
        int j=0;
        int ei = arr.length-1;

        while(i<=ei){
            if(arr[i]<=pivot){ // increase smaller area
                swap(arr,i,j);
                i++;
                j++; 
            } else { // increase larger area
                i++;
            }
        }
    }

    public static int partitionPivot(int[] arr, int pivot, int si, int ei){
        int i = si;
        int j = si;

        while(i<=ei){
            if(arr[i]<=pivot){ // increase smaller area
                swap(arr,i,j);
                i++;
                j++; 
            } else { // increase larger area
                i++;
            }
        }

        return j-1;
    }
    public static void quickSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int pivot = arr[ei];

        int pidx = partitionPivot(arr, pivot, si, ei);
        quickSort(arr, si, pidx - 1);
        quickSort(arr, pidx + 1, ei);
    }
    public static void main(String[] args) {
        int[] arr = {9,12,5,10,14,3,10};

        partition(arr, 10);
        System.out.println(Arrays.toString(arr));
        // quickSort(arr, 0, arr.length-1);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }
    }
}

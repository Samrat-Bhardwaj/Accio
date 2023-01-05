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
    public static void main(String[] args) {
        int[] arr = {10,9,4,11,20};
        printReverse(arr,0);
    }
}

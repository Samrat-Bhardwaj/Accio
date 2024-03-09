public class Swap {
    public static void swapValues(int[] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[2];
        arr[0] = 4;
        arr[1] = 10;

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        
        swapValues(arr);

        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }
}

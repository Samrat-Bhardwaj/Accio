public class Main {
    public static void main(String[] args) {
        
        int[] arr = new int[5];
        int[] arr2 = {1,2,3,4,5,5};

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        for(int ele: arr){
            System.out.println(ele);
        }
    }
}

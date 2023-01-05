public class Main {
    public static void increaseArray(int[] arr){
        arr[0]++;
    }

    public static void increaseInteger(int a){
        a++;
    }
    public static void main(String[] args) {
        int[] arr = new int[1];
        
        arr[0] = 5;

        int a = 5;
        increaseArray(arr);
        increaseInteger(a);

        System.out.println("Value of array "+arr[0]);
        System.out.println(a);
    }    
}

import java.util.Scanner;

public class Main {
    public static void ArrayOperations(int[] arr, int n) {
         // sum, average, max 
        int sum = 0;
        int average = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            sum = sum + arr[i];
        }

        average = sum/n;

        // 10,4,5,6,88
        for(int i=0; i<n; i++){
            int ele = arr[i];

            if(ele > max){
                max = ele;
            }
        }

        System.out.print(sum + " " + average + " " + max);
    }















    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            int input = scn.nextInt();
            arr[i] = input;
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }

        System.out.println(sum);
    }
}

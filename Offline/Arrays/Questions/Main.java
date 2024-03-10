import java.util.Scanner;

public class Main {
    public static void swap(int[] arr, int si, int ei){
        int value_at_si = arr[si];
        int value_at_ei = arr[ei];

        arr[si] = value_at_ei;
        arr[ei] = value_at_si;
    }

    public static void reverseArray(int arr[])
    {
        int si = 0;
        int ei = arr.length - 1;

        while(si<ei){
            // swapping values
            // swap(arr,si,ei);
            int value_at_si = arr[si];
            int value_at_ei = arr[ei];

            arr[si] = value_at_ei;
            arr[ei] = value_at_si;

            // moving 
            si++;
            ei--;
        }
    } 
    // https://course.acciojob.com/idle?question=4646f95a-5155-4d44-acfc-a6c6e4eebbf4
    public static int[] SumArrayExpectSelf(int[] nums, int n) {
        int[] res = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++){
            int ele = nums[i];
            sum+=ele;
        }

        for(int i=0; i<n; i++){
            res[i] = sum - nums[i];
        }

        return res;
    }


    // https://course.acciojob.com/idle?question=b862c888-5ff2-485c-abf2-401147f782f9
    // Second largest element in array

    public static void SecondLargest(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for(int ele: arr){
            if(ele > largest){
                second_largest = largest;
                largest = ele;
            } else if(ele > second_largest){
                second_largest = ele;
            }
        }

        System.out.println(second_largest);
    }


    // https://course.acciojob.com/idle?question=c2e81e59-e1a6-474f-b375-daf9b6c8f7a4
    // return frequency of elements greater than 35
    public static int ArrayProblem2(int n, int[] arr){
        int count = 0;

        for(int i=0; i<n; i++){
            int ele = arr[i];

            if(ele > 35){
                count++;
            }
        }

        return count;
    }

    // Array Operations
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

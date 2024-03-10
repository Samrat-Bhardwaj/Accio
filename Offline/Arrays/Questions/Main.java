import java.util.Scanner;

public class Main {

    public static int[] calSum(int a1[], int a2[], int n, int m) {
        int res_size = Math.max(n,m) + 1;

        int[] res = new int[res_size];

        int i= n - 1;
        int j = m - 1;
        int k = res_size - 1;
        int carry = 0;

        while(k>=0){
            int csum = 0;
            if(i>=0){
                csum += a1[i];
            }
            if(j>=0){
                csum += a2[j];
            }

            csum+= carry;

            if(csum>9){
                carry = 1;
                csum = csum%10;
            }
            
            res[k] = csum;

            i--;
            j--;
            k--;
        }

        return res;
    }

    // https://course.acciojob.com/idle?question=cdcb9e4d-fa09-4b0c-9e8e-2c23a7cf92ac
    public static void buildings(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for(int ele: arr){
            // if(ele > max){
            //     max = ele;
            // }
            max = Math.max(max,ele);
        }

        int current_number_of_line = max; // 9

        while(current_number_of_line > 0){
            // work
            for(int pos=0; pos<n; pos++){
                int pos_height = arr[pos];

                if(current_number_of_line <= pos_height){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            // prepare for next line
            System.out.println();
            current_number_of_line--;
        }
    }





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

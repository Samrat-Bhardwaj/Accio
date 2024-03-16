import java.util.Scanner;

public class Main {

public static void reverse(int[] nums, int si, int ei){
    while(si<=ei){
        int temp = nums[si];
        nums[si] = nums[ei];
        nums[ei] = temp;

        si++;
        ei--;
    }
}

public static void rotateArray(int[] nums, int k) {
    int n = nums.length;

    k = k%n; 

    if(k<0){
        k = k + n;
    }

    // k -> {0,n-1};
    reverse(nums,0,n-k-1); // left part reverse
    reverse(nums,n-k,n-1); // right part reverse

    reverse(nums,0,n-1); // whole array reverse
}

// Kadane's algorithm ====================================
public static int maxSubArraySum(int arr[]) {
    int max_sum = 0;
    int csum = 0;

    for(int i=0; i<arr.length; i++){
        csum += arr[i];

        if(csum < 0){
            csum = 0;
        }

        // msum = Math.max(msum, csum);
        if(max_sum < csum){
            max_sum = csum;
        }
    }

    return max_sum;
}

// what's the SP and EP of the max subArray (HomeWork)



// subarray sum divisble by k
public static boolean subarraySumDivisbleByK(int[] arr, int sp, int ep, int k){
    int sum = 0;

    int i = sp;
    while(i<=ep){
        sum += arr[i];
        i++;
    }

    return (sum%k == 0);;
}

public static int subarrayDivisbleByK(int arr[], int n, int k){
    int ans = 0;
    for(int sp = 0; sp<n; sp++){
        int sum = 0;
        for(int ep = sp; ep<n; ep++){
            // subarray from sp to ep
            // check if array from sp to ep is divisible by k
            sum += arr[ep];
            if(sum%k == 0){
                ans++;
            }
        }
    }

    return ans;
}


static boolean swap = false;
public static int[] subtract(int[] a1, int[] a2) {
    if(a1.length < a2.length){
        // swapping a1 and a2 addresses
        int[] temp = a1;
        a1 = a2;
        a2 = temp;
        swap = true;
    }

    int n = a1.length; 
    int m = a2.length; 

    int[] res = new int[n];
    int i = n-1;
    int j = m-1;
    int k = res.length - 1;
    int borrow = 0;

    while(k>=0){
        if(borrow == 1){
            a1[i]--; // this is wrong
            borrow = 0;
        }

        if(a1[i] < 0){
            a1[i] += 10;
            borrow = 1;
        }

        if(j<0){
            res[k] = a1[i]; 
        } else if(a1[i] >= a2[j]){
            res[k] = a1[i] - a2[j];
        } else {
            res[k] = (a1[i] + 10) - a2[j];
            borrow = 1;
        }
        i--;
        j--;
        k--;
    }
    return res;
}

    public static int ArrayProblem(int []arr,int k){
        int count = 0;
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int csum = arr[i] + arr[i+1];

            if(csum == k){
                count++;
            }
        }

        return count;
    }

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
            } else {
                carry = 0;
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
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
        sc.close();

        int[] res = calSum(arr1, arr2, n1, n2);

        if(res[0]==0){
            for(int i=1; i<res.length; i++){
                System.out.println(res[i]);
            }
        } else {
            for(int i=0; i<res.length; i++){
                System.out.println(res[i]);
            }
        }
    }
}

public class Main {
    // power 
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }

        int sAns = power(x,n-1);
        int ans = x * sAns;

        return ans;
    }

    // power logarithmic 
    public static int power_log(int x, int n){
        if(n==0){
            return 1;
        }

        int sAns = power_log(x, n/2);

        int ans=0;
        if(n%2==0){ // if n is even
            ans = sAns * sAns;
        } else { // if n is odd
            ans = sAns * sAns * x;
        }

        return ans;
    } 

    // sum of first n natural numbers 
    public static int sum_natural(int n){
        if(n==0){
            return 0;
        }

        int sAns = sum_natural(n-1);
        int ans = n + sAns;

        return ans;
    }

    // print array recursively =======================================
    public static void printArray(int idx, int[] arr){
        if(idx == arr.length){
            return;
        }

        System.out.println(arr[idx]);
        printArray(idx+1, arr);
    }

    public static void main(String[] args) {
        // int ans = power(2, 4);

        // System.out.println(ans);

        int[] arr ={7,3,2,0,9};
        printArray(0, arr);
    }
}

class Main {
    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void pdi(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int smallAns = factorial(n-1);
        int ans = smallAns * n;
        return ans;
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int smallAns = power(x, n-1);
        int ans = smallAns * x;
        return ans;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 4;
        int ans = power(x,n);
        System.out.println(ans);
    }
}
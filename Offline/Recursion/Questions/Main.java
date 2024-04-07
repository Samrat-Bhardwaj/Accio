class Main {
    public static int power(int x, int y){
        if(y == 0){
            return 1;
        }

        int smallerAns = power(x, y-1);
        int ans =  smallerAns * x;

        return ans;
    }

    public static int power_better(int x, int y){
        if(y==0){
            return 1;
        }
        int smallerAns = power_better(x, y/2);

        int ans = smallAns * smallAns; // O(logY)
        // int ans = power_better(x, y/2) * power_better(x, y/2); O(Y)

        if(y % 2 != 0){
            ans = x*ans;
        }

        return ans;
    }

    // Tower of HANOI ============================================
    public static void toh(int n, int A, int C, int B){
        if(n==0){
            return;
        }

        toh(n-1, A, B, C);
        // move nth ring from A to C
        System.out.println("Moving " + n + " ring from " + A + " -> " + C);

        toh(n-1, B, C, A);
    }

    // fibonacci series =========================
    public static int fib(int n){
        if(n  == 0){
            return 0;
        }
        if(n  == 1){
            return 1;
        }

        int lastTerm = fib(n-1);
        int secondLastTerm = fib(n-2);

        int nthTerm = lastTerm + secondLastTerm;
        return nthTerm;    
    }

    // product of first n natural numbers =======================
    public static long product(int n){
		if(n == 1){
            return 1;
        }

        long smallAns = 0;
        smallAns = product(n-1);
        long ans = n * smallAns;

        return ans;
    }

    public static void main(String[] args){
    //    printDecreasingIncreasing(5);
        // int a = 5, b=7;
        // int n = 4;
        // fib(n);

        // int sum = a + b;
        toh(4,10,30,20);
    }
}
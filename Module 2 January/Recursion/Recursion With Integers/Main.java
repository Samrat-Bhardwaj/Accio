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

    public static int power2(int x, int n){
        if(n==0){
            return 1;
        }
        int smallAns = power2(x, n/2);
        int ans = smallAns * smallAns;

        if(n%2 != 0){
            ans = ans*x;
        }

        return ans;
    }

    public static void towerOfHanoi(int n, int A, int B, int C){
        if(n==0){
            return;
        }

        towerOfHanoi(n-1, A, C, B);
        // move nth disc from A to b
        System.out.println("Moving ring " + n + "from" + A + " to " + B + " using " + C);
        towerOfHanoi(n-1, C, B, A);
    }

    // portal 
    static void TOH(int n, char A, char B, char C){
		if(n==0){
			return;
		}

		TOH(n-1,A,C,B);
		System.out.println("Moving ring " + n + " from " + A + " to " + B);
		TOH(n-1,C,B,A);
	}
	
    static void towersOfHanoi(int n, char source, char dest) {
      TOH(n,source,dest,'C');
    }

    public static void main(String[] args) {
       int n = 3;
       towerOfHanoi(n, 10, 20, 30);
    }
}
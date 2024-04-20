class Main {
    public static long product(int n){
		if(n == 1){
            return 1;
        }

        long smallAns = product(n-1);
        long ans = n * smallAns;

        return ans;
    }

    public static void printDecreasingIncreasing(int n){
        if(n == 1){
            System.out.println(1);
            return;
        }

        System.out.println(n);
        printDecreasingIncreasing(n-1);
        System.out.println(n);
    }

    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }

        printIncreasing(n-1);
        System.out.println(n);
    }


    public static void printNumbers(int n){
        if(n == 0){
            return;
        }

        System.out.println(n);
        printNumbers(n-1);
    }

    public static void swap2(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(int a, int b){
        swap2(b,a);
        
    }

    public static int sum(int a, int b){
        int ans = a + b;
        return ans;
    }

    public static void printZigZag(int n){
        if(n == 0){
            return;
        }

        System.out.println(n + "Pre");

        printZigZag(n-1);

        System.out.println(n + "In");

        printZigZag(n-1);

        System.out.println(n + "Post");
    }
    public static void main(String[] args){
    //    int x = 5;
    //    int y = 45;

    //    int ans = sum(x,y);
    //    System.out.println(ans);
        printZigZag(2);
    }
}
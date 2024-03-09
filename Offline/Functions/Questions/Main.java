import java.util.*;

public class Main {
    // bonary to decimal
    public static int binaryToDecimal(int binaryNumber) {
        int res = 0;
        int curr_pow_of_two = 1;

        while(binaryNumber > 0){
            int ld = binaryNumber % 10;

            res = res + ld * curr_pow_of_two;

            binaryNumber=binaryNumber / 10;
            curr_pow_of_two=curr_pow_of_two * 2;
        }

        return res;
    }

    // calculate nCr
    public static int fact(int x){
        int ans = 1;
        for(int i=1; i<=x; i++){
            ans = ans * i;
        }

        return ans;
    }
    
    public static int calculate_nCr(int n, int r) {
        int fact_of_n = fact(n);
        int fact_of_r = fact(r);
        int fact_of_n_minus_r = fact(n-r);

        int result = fact_of_n / (fact_of_r * fact_of_n_minus_r);

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int ans = calculate_nCr(n,r);
        System.out.print(ans);
        System.out.print(global_Var);
    }
}
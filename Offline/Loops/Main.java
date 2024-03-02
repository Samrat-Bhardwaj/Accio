import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // int i;
        // boolean isPrime = true;
        // for(i=2; i<num; i++){
        //     int rem = num % i;
        //     if(rem == 0){
        //         isPrime = false;
        //         break;
        //     }
        // }

        // if(isPrime){
        //     System.out.println(num+" is a prime number");
        // } else {
        //     System.out.println(num+" is not a prime number");
        // }

        int num = sc.nextInt();
		//Write your code here
        int ans = 0;
        while(num > 0){
            int ld = num%10;
            num = num/10;

            ans = ans*10 + ld;
        }

        System.out.println(ans);
    }
}
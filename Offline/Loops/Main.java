import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int i;
        boolean isPrime = true;
        for(i=2; i*i<=num; i++){
            int rem = num % i;
            if(rem == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println(num+" is a prime number");
        } else {
            System.out.println(num+" is not a prime number");
        }
    }
}
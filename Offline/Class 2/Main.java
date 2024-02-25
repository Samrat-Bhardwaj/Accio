import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt(); // 12345

        int fifth_digit = num % 10; // 12345 % 10 = 5

        // removing fifth_digit 
        num = num/10; // num = 1234

        int fourth_digit = num % 10;

        // removing fourth_digit 
        num = num/10;

        int third_digit = num%10;

        // removing third_digit 
        num = num/10;

        int second_digit = num%10;
        // removing second_digit 
        num = num/10;

        int first_digit = num%10;
        // removing first_digit 
        num = num/10;

        int ans = first_digit + fourth_digit;
        System.out.println(ans);
    }
}

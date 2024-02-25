import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt(); // 12345

        int first_digit = num/10000;

        // removing last (fifth) digit
        num = num/10; // 1234

        int fourth_digit = num%10;

        int ans = first_digit + fourth_digit;

        System.out.println(ans);
    }
}

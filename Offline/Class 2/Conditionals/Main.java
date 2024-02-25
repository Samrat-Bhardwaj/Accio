import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int remainder = num%2;
        if(remainder == 0){
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }
}

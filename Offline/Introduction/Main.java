import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        int fd  = 0;
        int sd  = 0;
        int td  = 0;

        td = num % 10; // retrieve my last digit 

        // i dont need my third digit
        num = num/10; // deleting my last digit

        sd = num%10;
        num = num/10;

        fd = num%10;
        num = num/10;

        int reversedNumber = td*100 + sd*10 + fd*1;
        System.out.println(reversedNumber);
    }
}
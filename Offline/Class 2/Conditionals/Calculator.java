import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int a = 10;

        if(a++ == 11){ // first comparison, then increment (post increment)
            System.out.println("value of a is 11");
        }
        if(--a == 10){
            System.out.println("Value of a is 95");
        }
        a--;

        System.out.println(a);
    }
}

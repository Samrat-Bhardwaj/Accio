import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int current_number_of_line = 1;
        int total_number_of_line = n;
        int stars = 1;
        int spaces = n-1;

        while(current_number_of_line <= total_number_of_line){
            // print spaces
            for(int i=0; i<spaces; i++){
                System.out.print(" ");
            }

            // print stars
            for(int i=0; i<stars; i++){
                System.out.print("*");
            }

            // next line prepration 
            System.out.println();
            stars++;
            spaces--;
            current_number_of_line++;
        }
    }
}

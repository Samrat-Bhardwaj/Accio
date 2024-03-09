import java.util.Scanner;

public class Main {
    public static void numberDiamond(int n){
        int total_number_of_line = 2*n-1;
        int current_number_of_line = 1;

        int stars = 1;
        int spaces = n-1;

        while(current_number_of_line <= total_number_of_line){
            // print spaces
            for(int i=1; i<=spaces; i++){
                System.out.print("  ");
            }

            // print stars
            int number_to_print = 1;
            for(int i=1; i<=stars; i++){
                System.out.print(number_to_print+" ");
                if(i <= stars/2){
                    number_to_print++;
                } else {
                    number_to_print--;
                }
            }


            // prepare for next line
            if(current_number_of_line < n){
                stars = stars + 2;
                spaces--;
            } else {
                stars = stars - 2;
                spaces++;
            }
            System.out.println();
            current_number_of_line++;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int total_number_of_line = n;
        // int current_number_of_line = 1;
        // int stars = 1;
        // int spaces= n-1;

        // while(current_number_of_line <= total_number_of_line){
        //     // print stars
        //     for(int i=1; i<=stars; i++){
        //         System.out.print(i+" ");
        //     }

        //     // print spaces
        //     for(int i=1; i<=spaces; i++){
        //         System.out.print("  ");
        //     }

        //     // prepare for next line
        //     System.out.println();
        //     stars++;
        //     spaces--;
        //     current_number_of_line++;
        // }

        // int total_number_of_line = n;
        // int current_number_of_line = 1;
        // int number_to_print = 1;
        // int stars = n;
        // int spaces= 0;

        // while(current_number_of_line <= total_number_of_line){
        //     // print spaces
        //     for(int i=1; i<=spaces; i++){
        //         System.out.print("  ");
        //     }

        //     // print stars
        //     for(int i=1; i<=stars; i++){
        //         System.out.print(number_to_print+" ");
        //         number_to_print++;
        //     }

        //     // prepare for next line
        //     System.out.println();
        //     spaces++;
        //     stars--;
        //     current_number_of_line++;
        // }

            numberDiamond(n);
    }
}

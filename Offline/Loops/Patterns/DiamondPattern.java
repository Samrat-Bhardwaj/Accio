import java.util.*;
class Main{
	public static void main(String[] args){
        //Write your code here 
        //Take required input and print the output
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t > 0){
            int n = scn.nextInt();
            int current_number_of_line = 1;
            int total_number_of_line = n;
            int stars = 1;
            int spaces = n/2;  
    
            while(current_number_of_line <= total_number_of_line){
                // print spaces
                for(int i=1; i<=spaces; i++){
                    System.out.print("  ");
                }
    
                // print stars
                for(int i=1; i<=stars; i++){
                    System.out.print("* ");
                }
    
                // prepare for next line
                System.out.println();
                if(current_number_of_line <= n/2){
                    spaces--;
                    stars = stars+2;
                } else {
                    spaces++;
                    stars = stars-2;
                }
                current_number_of_line++;
            }

            t--;
        }
	}

}
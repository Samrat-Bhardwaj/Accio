import java.util.Scanner;

public class ReportCard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int marks = scn.nextInt(); // 85

        if(marks>90){
            System.out.println("Excellent");
        } else if(marks>80){ // marks<=90
            System.out.println("Very good");
        } else if(marks>60){
            System.out.println("Good");
        } else {
            System.out.println("Bye");
        }
    }
}











// if(marks>90){
//     System.out.println("Excellent");
// }
// if(marks>80 && marks<=90){
//     System.out.println("Very Good");
// } 
// if(marks>60 && marks<=80){
//     System.out.println("Good");
// }
// if(marks<60){
//     System.out.println("Bye");
// }

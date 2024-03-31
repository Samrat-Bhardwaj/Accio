import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> al= new ArrayList<>();

        for(int i=0; i<5; i++){
            int val = scn.nextInt();
            al.add(val);
        }

        int sum = 0;
        int product =  1;

        for(int i=0; i<al.size(); i++){
            int cv = al.get(i);
            sum += cv;
            product *= cv;
        }

        System.out.println("sum is "+ sum);
        System.out.println("product is "+ product);
    }
}
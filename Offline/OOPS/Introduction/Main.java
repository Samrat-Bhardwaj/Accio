import java.util.ArrayList;
class Student {
    String name;
    int roll_no;

    public void makeNoise(){
        System.out.println("Making Noise!!!!");
    }

    public int sum(int a, int b){
        return a+b;
    }

    public String toString(){
        String s = "Name of the student is " + name + " and Roll number is " + roll_no;

        return s;
    }
}

class Main {
    public static void main(String[] args){
        Student s1 = new Student();
        
        s1.name = "Accio";
        s1.roll_no = 1;

        Student s2 = new Student();
        s2.name = "Ram";
        s2.roll_no = 2;

        // System.out.println(s1);
        // System.out.println(s2);
        // s1.makeNoise();
        // System.out.println(s1.sum(2,3));

        System.out.println(s1);
    }
}
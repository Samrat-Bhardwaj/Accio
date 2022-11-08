class Student {
    String name;
    int roll_number=1;
    int class_number=12;

    public void print(int roll_number){

        System.out.println(roll_number);
    }
}

public class Example {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.print(15);
    }
}

import java.util.ArrayList;
class Student {
    String name = "Accio";
    int roll_no = 234;
    int marks;

    // default constuctor 
    public Student(){
        System.out.println("Default Constructor is called");
    }

    public Student(String name){
        this.name = name;
        System.out.println("Parametrized Constructor with just name is called");
    }

    public Student(String name, int roll_no){
        this(name);
        this.roll_no = roll_no;
        System.out.println("Parametrized Constructor is called");
    }

    public Student(String name, int roll_no, int marks){
        this(name,roll_no);
        this.marks = marks;
        System.out.println("third Parametrized Constructor is called");
    }
}

class Main {

    public static void main(String[] args){
        Student s1 = new Student("A",23,67);
        System.out.println(s1.name);
        System.out.println(s1.roll_no);
        System.out.println(s1.marks);
    }
}
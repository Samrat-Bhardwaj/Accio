class Student {
    String name;
    int age;
    int roll_no;

    public Student(){
        System.out.println("Default constructor is called");
    }

    public Student(String name){
        this.name = name;
        System.out.println("constructor 1 is called");
    }

    public Student(String name, int age){
        this(name);
        System.out.println("constructor 2 is called");
    }

    public Student(String name, int age, int roll_no){
        this(name,age);
        this.roll_no = roll_no;
        System.out.println("constructor 3 is called");
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        // Student s1 = new Student();
        // Student s2 = new Student("Accio");
        Student s3 = new Student("Accio",12,234);
        // Student s4 = new Student("Accio",45);
    }    
}

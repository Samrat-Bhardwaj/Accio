class Student {
    String name = "CE"; 
    int age = 1336;
    int roll_no = -10;

    // default constructor
    public Student(){
        System.out.println("Constructor 1 is called");
    }

    // parametrized constructor
    public Student(String newName, int newAge, int newRoll_no){
        System.out.println("Constructor 2 is called");
        name = newName;
        age = newAge;
        roll_no = newRoll_no;
    }

    public Student(int newAge, int newRoll_no){
        System.out.println("Constructor 3 is called");
        System.out.println(age);
        age = newAge;
        roll_no = newRoll_no;
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        // Student s1 = new Student("Mahesh",11,1);
        Student s2 = new Student();
        // Student s3 = new Student(-100,-200);

        // System.out.println("Student Object with properties "+s1.name+" "+s1.age+" "+s1.roll_no);
        // System.out.println("Student Object with properties "+s2.name+" "+s2.age+" "+s2.roll_no);
        // System.out.println("Student Object with properties "+s3.name+" "+s3.age+" "+s3.roll_no);
    }    
}

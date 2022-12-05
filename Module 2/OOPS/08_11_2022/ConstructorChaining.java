class Student {
    String name="Pratik";
    int roll_number=1;
    int class_number=12;
    
    // parametrized constructors 
    //cons 1
    public Student(){
        
    }
    
    public Student(String n){ // cons2
        System.out.println("Constructor 2 is called");
        this.name=n;
    }
    
    public Student(String n, int rn){ // cons3
        this(n);
        System.out.println("Constructor 3 is called");
        this.roll_number=rn;
    }
    
    public Student(String n, int rn, int cn){ // cons4
        this(n,rn); // calling 3rd constructor
        System.out.println("Constructor 4 is called");
        this.class_number=cn;
    }
    
}

public class ConstructorChaining {
    public static void main(String[] args) {
        Student s1=new Student("Accio",10);
        
        // s1.doSomething(123);
    }
}

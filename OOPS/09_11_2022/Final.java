class Student {
    final String name="Accio";
    static int a=5;
    
    public void changeName(){
        name = "Pratik"; // error -> The final field Student.name cannot be assigned
        a++; 
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
    }
}

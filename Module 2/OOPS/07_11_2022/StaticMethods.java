class Student {
    String name;
    static int count=0;
    
    public Student(String n){
        name=n;
        count=count+1;
    }
    
    public static void Bunk(){
        count=56;
        System.out.println("Bunking the classes");
    }
    
    public void dontBunk(){
        System.out.println("Still bunking the classes");
    }
}

public class StaticMethods {
    public static void main(String[] args) {
        // Student s1=new Student("Pratik");
        // s1.dontBunk();
         
         Student.Bunk();
         System.out.println(Student.count);
     }
}

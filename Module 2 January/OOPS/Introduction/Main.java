// blueprint for student 
class Student {
    String name = "Accio"; 
    int age = 13;
    int roll_no = 1;

    public void makeNoise(){
        System.out.println("Making noise from "+name);
    }

    public void increaseAge(){
        age++;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("Properties of s1 -> " + s1.name+" "+s1.age+" "+s1.roll_no);

        s1.name = "Mahesh";
        s1.age = 11;
        s1.roll_no = 10;

        Student s2 = new Student();
        s2.name = "Rajesh";
        s2.age = 12;
        s2.roll_no = 11;

        System.out.println("Properties of s1 -> " + s1.name+" "+s1.age+" "+s1.roll_no);
        // System.out.println("Properties of s2 -> " + s2.name+" "+s2.age+" "+s2.roll_no);
        
        // s1.makeNoise();
        // s2.makeNoise();
    }    
}

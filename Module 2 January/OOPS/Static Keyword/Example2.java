import java.util.ArrayList;

class Student {
    String name ; 
    int age ;
    int roll_no;

    public Student(String name, int age, int roll_no){
        this.name = name;
        this.age = age;
        this.roll_no = roll_no;
    }

    public void fun(){
        System.out.println("I am "+name);
    }

    @Override // refer polymorphism 
    public String toString(){
        // return "bvd";
        return "Name of the student is " + name + " with an age of " + age + " and a roll number " + roll_no;
        // return "Return this statement";
    }
}

public class Example2 {
    public static void main(String[] args) {
        Student s1 = new Student("Sanket", 23, 1);
        Student s2 = new Student("Rajesh", 19, 11);
        Student s3 = new Student("Mahesh", 21, 49);

        System.out.println(s3);
        System.out.println(s1);

        // int[] arr = new int[5];
        // System.out.println(arr);

        // ArrayList<Integer> al = new ArrayList<>();
        // al.add(5);

        // System.out.println(al);
    }
}

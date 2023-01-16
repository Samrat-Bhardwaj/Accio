class Student {
    String name = "CE"; 
    int age = 1336;
    
    public void fun(int age){
        this.age++;
        // this.fun();
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class ThisKeywordExample {
    public static void main(String[] args) {
        Student s1 = new Student("Accio",23);

        s1.fun(100);

        System.out.println(s1.age);
        // System.out.println(s1.name+" "+s1.age);
    }
}

class Student {
    String name;
    int roll_no;
    private int marks;
    
    public Student(String name, int roll_no, int marks){
        this.name = name;
        this.roll_no = roll_no;
        this.marks = marks;
    }

    // getter 
    public int getMarks(){
        return this.marks;
    }

    // setters
    public void setMarks(int marks){
        if(marks >=100){
            System.out.println("Dont cheat !!!!!!!!");
            return;
        }
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Rajesh", 12, 50);

        s1.setMarks(100);
        System.out.println(s1.getMarks());
    }    
}

class Student {
    String name;
    int roll_no;
    static int total_students = 0;

    public Student(String name, int roll_no){
        this.name = name;
        this.roll_no = roll_no;
        this.total_students++;
    }

    public static void printTotalStudents(){
        System.out.println("Total students are " + total_students);
        name = "45";
    }
}

class Main {
    public static void main(String[] args){
        Student.printTotalStudents();
    }
}
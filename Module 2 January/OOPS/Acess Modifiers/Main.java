class Student {
    private int roll_no = 50;

    private void display(){
        roll_no++;
        System.out.println("Displaying");
    }
}

class smallStudent extends Student {
    public void increaseRoll_no(){
        // super.roll_no++; // compile time error
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        // s.display();
        // s.roll_no = 49;  not allowed
    }
}

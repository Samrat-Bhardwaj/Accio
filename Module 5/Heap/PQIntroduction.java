import java.util.Collections;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    int roll_no;
    String name;
    int class_no;

    public Student(int roll_no, String name, int class_no){
        this.roll_no = roll_no;
        this.name = name;
        this.class_no = class_no;
    }

    public int compareTo(Student other){
        // return this.roll_no - other.roll_no; // min pq
        // return other.roll_no - this.roll_no //=> max pq
        
        // return this.class_no - other.class_no; // smaller class number on the top of pq
        return other.class_no - this.class_no; // larger class number on the top
    }

    public String toString(){
        return "Name = " + this.name + " , Roll number = " + this.roll_no; 
    }    
}

public class PQIntroduction {
    public static void main(String[] args) {

        // PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // max Pq
        // PriorityQueue<Integer> minPq = new PriorityQueue<>(); /// min pq 
        PriorityQueue<Student> pq = new PriorityQueue<>();
        
        Student s1 = new Student(1, "Accio",2);
        Student s2 = new Student(2, "Job",5);
        Student s3 = new Student(-10, "Ram",10);

        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        System.out.println(pq.peek());
        // System.out.println(s1);
        // System.out.println(s2);
    }
}

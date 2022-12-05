// blueprint for student
class Student {
    String name;
    int roll_number; // class property -> rnOne 
    int class_number;

    // default constructor ========================== 
    public Student(){
        System.out.println("Constructor is called");
        name="Accio";
        roll_number=1;
        class_number=10;
    }
    
    // parametrized constructor
    public Student(String a, int rollNo, int classNo){
        System.out.println("constructor 2 is called");
        this.name=a;
        this.roll_number=rollNo; // value of variable at 4th line is being set
        this.class_number=classNo;
    }

    public void dontMakeNoise(){
        System.out.println("Shh!!!");
    }

    public void makeNoise(){
        System.out.println("We are making noise!!!!!");
        dontMakeNoise();
    }
}


public class OOP {
    
	public static void main(String[] args) {
		Student s1 = new Student(); // it will call the construtcor automatically,  it will create heap memory 
        Student s2= new Student("pratik",2,10);
        
        s1.makeNoise();
	}
}

class Student {
    String name;
    static String organisation="Accio";
    int roll_number;
    
    public Student(String n, int r){
        name=n;
        roll_number=r;
    }
}

class Car {
    int model_number;
    String owner_name;
    static String car_company="Hyundai";
}

public class StaticExample
{
	public static void main(String[] args) {
		Student s1=new Student("pratik",1);
		Student s2=new Student("Other",2);
		Student s3=new Student("Aakash",3);
		
		Student s4=new Student("Harsh",4);
		
		s2.organisation = "GFG";
		System.out.println(s4.organisation);
		System.out.println(s1.organisation);

        Car c1=new Car();
		c1.model_number=1;
		
		Car c2=new Car();
		c2.model_number=2;
		
		
		Car c3=new Car();
		c3.model_number=3;
		
		System.out.println(c1.car_company);
		
		c1.car_company="Rolls Royce";
		
		System.out.println(c3.car_company);
		System.out.println(c1.car_company);
	}
}

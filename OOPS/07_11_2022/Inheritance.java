class Vechile {
    int no_of_wheels;
    String color="Blue";
    
    public Vechile(){
        System.out.println("Vechile constructor is called");
    }
    
    public void makeSound(){
        System.out.println("Making Vehicle sound");
    }
}

class Car extends Vechile {
    int model_number;
    
    public Car(){
        System.out.println("Car constructor is called");    
    }
    
    public void carSound(){
        System.out.println("Making car sound");
    }
}

class Hyundai extends Car {
    String name;
    
    public Hyundai(){
        System.out.println("Hyundai constructor is called");
    }
}

public class Inheritance{
	public static void main(String[] args) {
	   Hyundai h1 = new Hyundai();
	}
}

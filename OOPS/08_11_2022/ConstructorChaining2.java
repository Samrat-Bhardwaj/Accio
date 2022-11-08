class Vechile {
    int no_of_wheels;
    String color="Blue";
    
    public Vechile(int now, String c){
        this.no_of_wheels=now;
        this.color=c;
    }
}

class Car extends Vechile {
    int model_number;
    
    public Car(int mn, int now, String c){
        super(now,c);
        this.model_number=mn;
    }
}

public class Main {
	public static void main(String[] args) {
	    Car c1 = new Car(15,4,"Black");
	    
	    System.out.println(c1.model_number);
	    System.out.println(c1.no_of_wheels);
	    System.out.println(c1.color);
	}
}

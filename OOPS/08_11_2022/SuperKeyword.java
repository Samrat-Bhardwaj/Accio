class Vechile {
    int no_of_wheels;
    String color="Blue";
    
    public void HonkVechile(){
        System.out.println("parent sound");
    }
}

class Car extends Vechile {
    int model_number;
    
    public void HonkVechile(){
        System.out.println("Child sound");
    }
    
    public void HonkCar(){ // this -> my own HonkVechile(13th line) , super-> parent's function(5th line)
        super.HonkVechile();
    }
}

public class Main {
	public static void main(String[] args) {
	    
	}
}

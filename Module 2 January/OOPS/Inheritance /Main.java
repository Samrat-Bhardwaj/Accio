class Vechile { //-> parent class / super class
    int now = 2; // number of wheels
    String color;

    public Vechile(){
        System.out.println("Constructor from vehicle class is called");
    }

    public void honk(){
        System.out.println("Honking from Vechile class");
    }
}

class Car extends Vechile { // child class / sub class
    int horsePowers;

    public Car(){
        System.out.println("Constructor from Car class is called");
    }

    public void run(){
        System.out.println("Running from child class");
    }
}

class Bike extends Vechile {
    public Bike(){
        System.out.println("Bike constructor");
    }
    int maxSpeed;
}

public class Main {
    public static void main(String[] args) {
        // Vechile v1 = new Vechile();
        // Car c1 = new Car();
        // c1.now = 4;
        // c1.color= "Red";
        // c1.horsePowers = 400;

        // c1.honk();
        // c1.run();

        Bike b1 = new Bike();
        // b1.now = 2;
        // b1.honk();
        // b1.maxSpeed=400;
    }    
}

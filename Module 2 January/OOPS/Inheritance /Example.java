class Vehicle {
    String color;
    int seats;

    public Vehicle(){
        // System.out.println("Default constructor");
    }

    public Vehicle(String color, int seats){
        System.out.println("Parametrized constructor");
        this.color = color;
        this.seats = seats;
    }

    public void Vehiclehonk(){
        System.out.println("Honking from the vehicle class");
    }
}

class Car extends Vehicle {
    int engine=47;

    public Car(){

    }
    public Car(String color, int seats, int engine){
        super(color, seats);
        this.engine = engine;
    }

    public void Vehiclehonk(){
        System.out.println("Honking from the Car class but vehicle");
    }

    public void CarHonk(){
        System.out.println("Honking from the car!!!!!!");
        this.Vehiclehonk();
    }

    public void doSomething(int engine){
        this.engine++;
    }

    public void doSomethingAgain(int seats){
        // super.seats++;
        // this.seats++;
        System.out.println(seats);
    }
}

class Hyundai extends Car {
    int model_number;

    public void HonkHonk(){
        super.Vehiclehonk();
    }

    public void increaseSeats(){
        super.seats++;
    }
}


public class Example {
    public static void main(String[] args) {
        // Car c1 = new Car();
        // c1.seats = 4;
        // c1.doSomethingAgain(34);
        // System.out.println(c1.seats);

        Hyundai h = new Hyundai();
        h.HonkHonk();
    }    
}

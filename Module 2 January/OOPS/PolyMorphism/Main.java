class Vehicle {
    String color;
    int seats;

    public void Vehiclehonk(){
        System.out.println("Honking from the vehicle class");
    }

    public int add(int a, int b){
        return a+b;
    }
}

class Car extends Vehicle {
    int engine=47;

    // method overLoading
    public void Vehiclehonk(int a){
        System.out.println("Honking from the Car class");
    }

    @Override // method overRiding
    public int add(int a, int b){
        return a + 1 + b + 1;
    }
}

class Hyundai extends Car {
    int model_number;

    // method overLoading
    public void Vehiclehonk(String a){
        System.out.println("Honking from Hyundai class");
    }
}


public class Main {
    public static void main(String[] args) {
        Hyundai h1 = new Hyundai();
        // h1.Vehiclehonk();

        Car c1 = new Car();
        System.out.println(h1.add(2, 1));

        // Vehicle v = new Vehicle();
        // System.out.println(v.add(2,1));
    }    
}

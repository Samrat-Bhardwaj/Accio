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

public class Example {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.Vehiclehonk(5); // this is visible at compile time 

        // upcasting 
        // Vehicle v = new Vehicle();
        Vehicle v = new Car();
        v.add(2,3); // this is resolved at run time
    }
}

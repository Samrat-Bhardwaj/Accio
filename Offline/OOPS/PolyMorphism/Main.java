class Vechile {
    String color;
    
    public void Honk(int a){
        System.out.println("A vechile function");
    }

    public void run(int a){
        System.out.println("Running in Vechile");
    }
}

class Car extends Vechile {
    String engineType;
    
    // method overloading 
    public void Honk(String s){
        System.out.println("A car function");
    }

    @Override
    public void run(int a){
        System.out.println("Runinng in car");
    }
}

class Bike extends Vechile {
    @Override
    public void run(int a){
        System.out.println("Runinng in Bike");
    }
}

class Main {
    public static void main(String[] args){
        Vechile obj = new Bike(); // upcasting
        obj.run(2);
    }
}
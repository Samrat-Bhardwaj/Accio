class Vechile {
    String color;
    int releaseYear;
    public Vechile(){
        System.out.println("Vechile Constructor");
    }
    public void Honk(){
        System.out.println("A vechile function");
    }
}
class Car extends Vechile {
    String engineType;
    public Car(){
        System.out.println("Car Constructor");
    }
    public void carHonk(){
        System.out.println("A car function");
    }
}
class Hyundai extends Car {
    int modelNumber; 

    public Hyundai(){
        System.out.println("Hyundai Constructor");
    }
    public void HyundaiHonk(){
        System.out.println("A Hyundai function");
    }
}
class Main {
    public static void main(String[] args){
        Hyundai h1 = new Hyundai();
        h1.Honk();
    }
}
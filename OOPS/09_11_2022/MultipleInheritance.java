interface A {
    public void honk();
}

interface B {
    public void honk();
}

class Car implements A,B {
    public void honk(){
        System.out.println("Honking");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.honk();
    }
}

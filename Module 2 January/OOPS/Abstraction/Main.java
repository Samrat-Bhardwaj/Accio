abstract class Vehicle {
    abstract public void display();

    public void fun(){
        System.out.println("Non abstract function");
    }
}

class Car extends Vehicle {
    public void display(){
        System.out.println("Defining abstact function");
    }
}

abstract class Shape {
    abstract void displayShape();
}

class Circle extends Shape {
    void displayShape(){
        System.out.println("Its a circle");
    }
}

class Rectange extends Shape {
    void displayShape(){
        System.out.println("Its a Rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        // Vehicle v = new Car();

        // v.display();
        Shape s = new Circle();
        s.displayShape();

        s = new Rectange();
        s.displayShape();
    }
}

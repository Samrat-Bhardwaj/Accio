abstract class Shape {
    public void saySomething(){
        System.out.println("hjbxjbx");
    }
    abstract void draw();
}

class Circle extends Shape {
    public void draw(){
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {
    public void draw(){
        System.out.println("Drawing rectangle");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        // upcasting 
        Shape s= new Circle();
        s.draw();

        s=new Rectangle();
        s.draw();
    }
}

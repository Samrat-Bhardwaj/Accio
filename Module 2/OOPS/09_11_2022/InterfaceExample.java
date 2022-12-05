interface Shape {
    public void draw();
    public void area();
}

class Circle implements Shape {
    public void draw(){
        System.out.println("Drawing circle");
    }

    public void area(){
        System.out.println("Circle area");
    }
}

class Rectangle implements Shape {
    public void draw(){
        System.out.println("Drawing Rectangle");
    }

    public void area(){
        System.out.println("Rectangle area");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.area();
    }
}

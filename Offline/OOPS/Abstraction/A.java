interface Shape { // 100% abstraction
    int val = 45;
    public void draw();
    public void area();
}

interface V { // 100% abstraction
    public void draw();
}

class Rectagle implements Shape, V {
    public void draw(){
        System.out.println("Drawing reactangle");
    }

    public void area(){
        System.out.println("Find it yourself, formula is l*b");
    }
}

class Circle implements Shape {
    public void draw(){
        val = 67; // cannot assign a value to final variable val
        System.out.println("Drawing Circle");
    }

    public void area(){
        System.out.println("Find it yourself, formula is pi*r*r");
    }
}

class A {
    public static void main(String[] args){
        Shape s; 

        s = new Circle();

        s.draw();
    }
}
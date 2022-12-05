abstract class Student {
    String name;
    
    public void print(){
        System.out.println("Printing something");
    }
    
    abstract void printAbstract();
    abstract void printNothing();
}

class Child extends Student {
    public void printAbstract(){
        System.out.println("Printing abstract");
    }

    public void printNothing(){
        System.out.println("Printing nothing");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Child c1 =new Child();
        Node address
    }
}

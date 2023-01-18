class Bank {
    public int rateOfInterest(){
        return 7;
    }
}
class HDFC extends Bank {
    public int rateOfInterest(){
        return 5;
    }
}
class SBI extends Bank {
    public int rateOfInterest(){
        return 6;
    }
}
class Kotak extends Bank {
    public int rateOfInterest(){
        return 8;
    }
}

class Parent {
    public static void display(){ // its binding at compile time -> static binding 
        System.out.println("Displaying from the parent class");
    }

    public int nonStaticAdd(int a, int b){
        return a+b;
    }
}

class Child extends Parent {
    public static void display(){
        System.out.println("Displaying from child class");
    }

    public int nonStaticAdd(int a, int b){
        return a - b;
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
       Parent p = new Child();
       System.out.println(p.nonStaticAdd(2,3));
       p.display();
        // Bank b;

        // b = new Bank(); 
        // System.out.println(b.rateOfInterest());

        // b = new HDFC(); // up casting, dynamic binding, late binding
        // System.out.println(b.rateOfInterest());

        // b = new SBI();
        // System.out.println(b.rateOfInterest());

        // b=new Kotak();
        // System.out.println(b.rateOfInterest());
    }
}

interface Shape {
    int a = 52; // by default this is final 
    void display(); // -> public abstract void display();
    void Honk();// -> public abstract void Honk();
}


class Circle implements Shape {
    public void display(){
       // a = 54; //  cannot assign a value to final variable a
        System.out.println("display functionn");
    }

    public void Honk(){
        System.out.println("Honk functionn");
    }
}
public class Interface {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.display();
        c.Honk();
    }
}

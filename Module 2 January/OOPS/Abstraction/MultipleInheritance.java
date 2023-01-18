interface A {
    void display();
}

interface B {
    void display();
}

interface D {
    void honk();
}

// multiple inheritance 
class C implements A,B,D {
    public void display(){
        System.out.println("display");
    }

    public void honk(){
        System.out.println("Honk");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        C obj = new C();
        obj.display();
    }
}

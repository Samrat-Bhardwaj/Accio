class Car {
    String color;
    static int count=34;

    public static void fun(){
        // color = "red"; // this is not allowed
        // fun2(); not allowed
        System.out.println("Static function is called");
        count = 39;
    }

    public void fun2(){
        color = "red";
        count = 44;
    }
}

public class Example {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "blue";
        c1.fun2();

        System.out.print(c1);

        // Car.fun2();

        // Car.fun();
        Car.count = 56;
    }
}

class Car {
    String color;
    int model_number;
    static String car_company="Mahindra";
    static int count = 0;

    public Car(){
        count++;
    }

    public void fun2(){
        color = "red";
        System.out.println("Having fun!!!!!!!!!!");
    }

    public static void fun(){
        // color="red"; // not possible
        count=56;
        // fun2();
        System.out.println("Having fun!!!!!!!!!!");
    }
}

public class Main { 
    class Student { //why we need to define this class as static
        int a;
    }

    public void fun(){
        Student s1 = new Student();  // this is possible 
    }
    public static void main(String[] args) {
    //    Student s1 = new Student(); // this is not possible

        Car c1 = new Car(); // and this is possible
        c1.color= "blue";

        Car c2 = new Car();
        c2.color = "Silver dust";

        Car c3 = new Car();
        c1.car_company = "Accio";
        c1.color="Red";

        // c3.count = 45;

        System.out.println(c2.car_company);
        System.out.println(c2.count);

    }
}

abstract class Vechile {
    public void printA(){
        System.out.println("Printing A!!!");
    }

    abstract public int sum(int a, int b);
    abstract public void printB();
}

class Car extends Vechile {
    public int sum(int a, int b) {
        return a + b;
    }

    public void printB(){
        System.out.println("Printing B!!!");
    }
}

class Main {
    public static void main(String[] args){
        Car c = new Car();

        c.printB();
    }
}
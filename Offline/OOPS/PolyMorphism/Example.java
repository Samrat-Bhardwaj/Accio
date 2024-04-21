class Bank {
    public int rateOfInterest(){
        return 5;
    }
}

class SBI extends Bank {
    public int rateOfInterest(){
        return 3;
    }
}

class HDFC extends Bank {
    public int rateOfInterest(){
        return 7;
    }
}

class Icici extends Bank {
    public int rateOfInterest(){
        return 4;
    }
}

public class Example {
    public static void main(String[] args) {
        Bank b; // compile time p "b" is of type bank

        b = new HDFC(); // run time , late binding
        System.out.println(b.rateOfInterest()); // method overriding 

        b = new SBI();
        System.out.println(b.rateOfInterest());
    }
}
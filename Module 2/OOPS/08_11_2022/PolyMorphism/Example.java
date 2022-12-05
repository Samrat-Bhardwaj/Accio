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
        Bank b; // at compile time "b" is of Bank type
        // upcasting 
        b=new SBI(); // at run time, when i allot space in Heap, "b" is actually of "SBI" type  ==> dynamic binding, late Binding
        System.out.println("Rate of interest is "+b.rateOfInterest());
        
        b=new Icici();
        System.out.println("Rate of interest is "+b.rateOfInterest());
    }
}

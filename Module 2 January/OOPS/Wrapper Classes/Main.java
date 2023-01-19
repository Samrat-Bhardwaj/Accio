public class Main {
    public static void main(String[] args) {
        int a = 5; // primitive data type 

        // Integer i = new Integer(a); // boxing -> wrapping 
        
        Integer i = a; // autoboxing 
        
        Integer obj = new Integer(100);
        
        // int ab = obj.intValue(); // unboxing -> unwrapping
        int ab = obj; // autoUnboxing
        
        // why?
        String s = "123";
        int b = Integer.parseInt(s);

        // Wrapper Classses 
        // int -> Integer;
        // char -> Character;
        // long -> Long;
        // boolean -> Boolean;
        // float -> Float;
        // byte -> Byte;
        // double -> Double;
        // short-> Short;
    }
}

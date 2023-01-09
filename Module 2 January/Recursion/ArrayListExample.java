import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("abc");
        al.add("def");
        al.add("abcd");

        System.out.println(al);

        al.remove(1);
        System.out.println(al);

        al.set(1,"Accio");
        System.out.println(al);
    }    
}

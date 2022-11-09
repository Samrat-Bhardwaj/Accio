class Vechile {
    int no_of_wheels;
    String color="Blue";
    
    public void Honk(){
        System.out.println("Honking with no parameters");
    }
    
    public void Honk(int a, int b){
        System.out.println("2 params");
    }
    
    public void Honk(String a, String b){
        System.out.println("peee peee "+a);
    }
    
    public void Honk(String s, int b){
        System.out.println("pee pee but different "+s);
    }
    
    public void Honk(int b, String s){
        System.out.println("Trying");
    }
}

public class Main {
	public static void main(String[] args) {
	   Vechile v1=new Vechile();
	   
	   v1.Honk("Accio",2);
	   v1.Honk(2,"Accio");
	}
}

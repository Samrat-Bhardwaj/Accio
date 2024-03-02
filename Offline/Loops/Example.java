
public class Example {
    public static void main(String[] args) {
        for(int i=10; i<20; i++){ // i =10,11,12,13,14,15
            System.out.println(i);
            if(i==15){
                break;
            } 
        }

        System.out.println("Outside for loop");
    }
}

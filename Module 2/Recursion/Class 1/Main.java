public class Main {
    public static void printSomething(){
        System.out.println("Hi!!");

        int a=5;
        a++;
        a--;

        a=11;
    }

    public static int sum(int a, int b){
        printSomething();

        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        int a=2;
        int b=3;

        int ans=sum(a, b);
        System.out.println(ans);
    }
}

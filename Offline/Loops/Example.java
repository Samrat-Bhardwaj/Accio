public class Example {
    public static int addNumbers(int x, int y){
        System.out.println("Starting of function");

        int sum = x + y;
        System.out.println(sum);

        return sum;
    }
    public static void main(String[] args) {
        System.out.println("This is line 1");

        int y = 44;
        int res = addNumbers(23, y);

        System.out.println(res);
    }
}

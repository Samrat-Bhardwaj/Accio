public class Main {
    public static void printSS(String str, int idx, String ans){
        if(idx==str.length()){
            System.out.println(ans);
            return;
        }

        // say yes to curr char
        printSS(str, idx + 1, ans+str.charAt(idx));

        // say no to curr char
        printSS(str, idx + 1, ans);
    }
    public static void main(String[] args) {
        String str = "abc";
        String ans = "";

        printSS(str,0,ans);
    }
}

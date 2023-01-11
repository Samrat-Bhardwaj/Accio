public class Main {
    public static void printSubs(String str, String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);
        String ss = str.substring(1);

        printSubs(ss, asf+ch);
        printSubs(ss, asf);
    }

    static String[] sarr = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str, String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        int fd = str.charAt(0) - '0';
        String ss = str.substring(1);

        String add = sarr[fd];

        for(int i=0; i<add.length(); i++){
            char toAdd = add.charAt(i);
            printKPC(ss, asf + toAdd);
        }
    }

    public static void printStairPaths(int n, String asf){
        if(n==0){
            System.out.println(asf);
            return;
        }

        if(n<0){
            return;
        }

        printStairPaths(n-1, asf+"1");
        printStairPaths(n-2, asf+"2");
        printStairPaths(n-3, asf+"3");
    }

    // print maze paths (HOMEWORK)

    // string encodings ====================================================
    public static void printEncodings(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        if(str.charAt(0)=='0'){
            return;
        }

        // taking first character
        int firstDigit = str.charAt(0) - '0';
        char charToAdd = (char)('a' + firstDigit - 1);
        String ss = str.substring(1);

        printEncodings(ss, asf+charToAdd);

        // taking first 2 char 
        if(str.length() >= 2){
            int firstTwoDigits = Integer.parseInt(str.substring(0,2));
            if(firstTwoDigits<=26){
                charToAdd = (char)('a' + firstTwoDigits - 1);

                ss = str.substring(2);
                printEncodings(ss, asf+charToAdd);
            }
        }
    }

    public static void main(String[] args) {
        // printSubs("abc", "");
        // printKPC("789", "");
        // printStairPaths(4,"");
        printEncodings("123","");
    }    
}

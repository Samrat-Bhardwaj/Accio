class Main {
    public static void printSubsequences(String str, String asf){
        if(str.equals("")){
            System.out.println(asf);
            return;
        }

        char currChar = str.charAt(0);
        String smallerString = str.substring(1);

        printSubsequences(smallerString, asf); // currChar said no
        printSubsequences(smallerString, asf + currChar); // currChar said yes
    }

    static String[] sarr = {"*#,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str, String asf){
        if(str.equals("")){
            System.out.print(asf+" ");
            return;
        }

        char firstChar = str.charAt(0); // "789" -> '7'
        String smallerString = str.substring(1);

        int idx = firstChar - '0'; // 7
        String key = sarr[idx];

        for(int i=0; i<key.length(); i++){
            char currChar = key.charAt(i);
            printKPC(smallerString, asf + currChar);
        }
    }

    public static void printStairPaths(int n, String asf){
        if(n == 0){
            System.out.print(asf+" ");
            return;
        }

        if(n < 0){
            return;
        }

        printStairPaths(n-1, asf + "1");
        printStairPaths(n-2, asf + "2");
        printStairPaths(n-3, asf + "3");
    }

    public static void printMazePaths(int i, int j, int n, int m, String asf){
        if(i==n-1 && j==m-1){
            System.out.print(asf+" ");
            return;
        }

        if(i>=n || j>=m){
            return;
        }

        printMazePaths(i,j+1,n,m, asf +"h");
        printMazePaths(i+1,j,n,m, asf +"v");
    }

    // "303", "1234"
    public static void printEncodings(String str, String asf){
        if(str.equals("")){
            System.out.println(asf);
            return;
        }
        if(str.charAt(0) == '0'){
            return;
        }

        String smallerString = str.substring(1); // "234"
        int firstNum = str.charAt(0) - '0'; // 1
        char toAdd = (char)(firstNum - 1 + 'a'); // 'a'

        printEncodings(smallerString, asf + toAdd); // {"234", "a"}


        if(str.length() >= 2){
            String first2NumberString = str.substring(0,2); // "12","3"
            int first2Nums = Integer.parseInt(first2NumberString); // 12

            if(first2Nums <= 26){
                toAdd = (char)(first2Nums - 1 + 'a'); // l
                String anotherSmallerString = str.substring(2); //"34"

                printEncodings(anotherSmallerString, asf + toAdd);
            }
        }
    }


    public static void main(String[] args){
        // printSubsequences("abc","");
        // printKPC("789","");
        // printStairPaths(3,"");
        printMazePaths(0,0,3,3,"");
    }
}
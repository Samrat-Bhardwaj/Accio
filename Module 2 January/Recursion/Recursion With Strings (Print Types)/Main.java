import java.util.ArrayList;

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

    // print permutations ========================================
    public static void permutationPrint(String ques, String asf) {
        if(ques.length()==0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<ques.length(); i++){
            char toAdd = ques.charAt(i);

            String leftPart = ques.substring(0, i);
            String rightPart = ques.substring(i+1, ques.length());

            String roq = leftPart + rightPart;
            permutationPrint(roq, asf+toAdd);
        }
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }

        // if(sr>dr || sc>dc){
        //     return;
        // }

        // horizontal steps 
        for(int jump = 1; jump<=dc-sc; jump++){
            printMazePaths(sr, sc + jump, dr, dc, psf + "h"+ jump);
        }

        // vertical steps
        for(int jump = 1; jump<=dr-sr; jump++){
            printMazePaths(sr+jump, sc, dr, dc, psf+"v"+jump);
        }

        // diagonal steps
        for(int jump=1; jump<=dc-sc && jump<=dr-sr; jump++){
            printMazePaths(sr + jump, sc + jump, dr, dc, psf+"d"+jump);
        }
    }


    // recursion on the way down =============================================
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int jump=1; jump<=dc-sc; jump++){
            ArrayList<String> hpaths = getMazePaths(sr, sc+jump, dr, dc);

            for(int i=0; i<hpaths.size(); i++){
                String hpath = hpaths.get(i);
                String path = "h" + jump + hpath;
                ans.add(path);
            }
        }

        for(int jump=1; jump<=dr-sr; jump++){
            ArrayList<String> vpaths = getMazePaths(sr+jump, sc, dr, dc);

            for(int i=0; i<vpaths.size(); i++){
                String vpath = vpaths.get(i);
                String path = "v" + jump + vpath;
                ans.add(path);
            }
        }

        for(int jump=1; jump<=dr-sr; jump++){
            ArrayList<String> dpaths = getMazePaths(sr+jump, sc+jump, dr, dc);

            for(int i=0; i<dpaths.size(); i++){
                String dpath = dpaths.get(i);
                String path = "d" + jump + dpath;
                ans.add(path);
            }
        }

        return ans;
    }

    // number of ways to make natural number 
    public static long ways(int sum, int ld){
		if(sum==0){
			return 1;
		}
		long ans = 0;

		for(int i=ld+1; i<=sum; i++){
			long smallAns = ways(sum - i, i);
			ans = ans + smallAns;
		}

		return ans;
    }
    public static void main(String[] args) {
        // printSubs("abc", "");
        // printKPC("789", "");
        // printStairPaths(4,"");
        printEncodings("123","");
    }    
}

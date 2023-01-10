import java.util.ArrayList;

public class Main {
    // getMazePaths ======================================
    public static ArrayList<String> getMazePaths(int i, int j, int n, int m){
        if(i>=n || j>=m){ // invalid state , out of matrix 
            ArrayList<String> ba = new ArrayList<>();
            return ba;
        }

        if(i==n-1 && j==m-1){
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
        ArrayList<String> allPaths = new ArrayList<>();

        ArrayList<String> hpaths = getMazePaths(i, j + 1, n, m);
        for(int k=0; k<hpaths.size(); k++){
            String hpath = hpaths.get(k);
            String path = "h" + hpath;

            allPaths.add(path);
        }

        ArrayList<String> vpaths = getMazePaths(i + 1, j, n, m);
        for(int k=0; k<vpaths.size(); k++){
            String vpath = vpaths.get(k);
            String path = "v" + vpath;

            allPaths.add(path);
        }

        return allPaths;
    }
    // get Stair paths ===============================================================================================
    public static ArrayList<String> getStairPaths(int n){
        if(n<0){ // no possible path 
            ArrayList<String> ba = new ArrayList<>();
            return ba;
        }

        if(n==0){
            ArrayList<String> ba = new ArrayList<>();
            ba.add(""); // not doing anything , just standing here (reached my destination)
            return ba;
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> sans = getStairPaths(n-1);

        for(int i=0; i<sans.size(); i++){ // take a jump of 1
            String spath = sans.get(i);
            String path = "1" + spath;
            ans.add(path);
        }

        sans = getStairPaths(n-2); // take a jump of 2
        for(int i=0; i<sans.size(); i++){
            String spath = sans.get(i);
            String path = "2" + spath;
            ans.add(path);
        }

        sans = getStairPaths(n-3); // take a jump of 3
        for(int i=0; i<sans.size(); i++){
            String spath = sans.get(i);
            String path = "3" + spath;
            ans.add(path);
        }

        return ans;
    }

    // get all keypad combinations ===================================================
    static String[] sarr = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str){
        if(str.length()==0){
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }

        int firstDigit = str.charAt(0) - '0';
        String ss = str.substring(1);

        ArrayList<String> sans = getKPC(ss);

        ArrayList<String> ans = new ArrayList<>();
        String add = sarr[firstDigit]; // string that we can replace this digit with

        for(int i=0; i<add.length(); i++){
            char toAdd = add.charAt(i);
            for(int j=0; j<sans.size(); j++){
                String sansString = sans.get(j);

                String ansString = toAdd + sansString;
                ans.add(ansString);
            }
        }

        return ans;
    }

    static void printKPC(String ques) {
        ArrayList<String> ans = getKPC(ques);
        for(int i=0; i<ans.size(); i++){
			System.out.println(ans.get(i));
		}
    }

    // get all subsequences ====================================================
    public static ArrayList<String> getSS(String str){
        if(str.length()==0){
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }

        char fc = str.charAt(0);
        String ss = str.substring(1);

        ArrayList<String> sans = getSS(ss);

        ArrayList<String> ans = new ArrayList<>();
        // copy sans 
        for(int i=0; i<sans.size(); i++){
            String ssub = sans.get(i); // not including char
            ans.add(ssub);

            // String sub = fc + ssub;
            // ans.add(sub);
        }

        // add first char
        for(int i=0; i<sans.size(); i++){
            String ssub = sans.get(i);
            String sub = fc + ssub;
            ans.add(sub);
        }

        return ans;
    } 

    public static void main(String[] args) {
        // String str = "789";
        // ArrayList<String> ans = getKPC(str);
        // System.out.println(ans);
        System.out.println(getStairPaths(4));
    }    
}

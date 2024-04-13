import java.util.ArrayList;
class Main {
    public static ArrayList<String> getMazePaths(int i, int j, int n, int m){
        if(i==n-1 && j==m-1){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        if(i>=n || j>=m){
            ArrayList<String> bans = new ArrayList<>();
            return bans;
        }

        ArrayList<String> allPaths = new ArrayList<>();

        // take a horizontal step
        ArrayList<String> hpaths = getMazePaths(i, j+1, n, m);

        for(String path: hpaths){
            allPaths.add("h" + path);
        }

        ArrayList<String> vpaths = getMazePaths(i+1, j, n, m);
        for(String path: vpaths){
            allPaths.add("v" + path);
        }

        return allPaths;
    }


    // GET STAIR PATHS ==========================================
    public static ArrayList<String> getStairPaths(int n){
        if(n < 0){
            ArrayList<String> bans = new ArrayList<>();
            return bans;
        }

        if(n==0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        ArrayList<String> allPaths = new ArrayList<>();

        ArrayList<String> oneStepPaths = getStairPaths(n-1);
        for(String s: oneStepPaths){
            allPaths.add("1" + s);
        }

        ArrayList<String> twoStepPaths = getStairPaths(n-2);
        for(String s: twoStepPaths){
            allPaths.add("2" + s);
        }
        
        ArrayList<String> threeStepPaths = getStairPaths(n-3);
        for(String s: threeStepPaths){
            allPaths.add("3" + s);
        }

        return allPaths;
    }

    // GET KEYPAD COMIBNATIONS ====================================================================
    static String[] sarr = {"*#,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPS(String str){
        if(str.equals("")){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        char firstChar = str.charAt(0);
        String smallerString = str.substring(1);

        ArrayList<String> smallerAns = getKPS(smallerString); // {"vy", "vz", "xy" ....}

        int idx = firstChar - '0';
        String key = sarr[idx]; // "tu"

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i<key.length(); i++){
            char currChar = key.charAt(i);

            for(String s: smallerAns){
                ans.add(currChar + s);
            }
        }

        return ans;
    }

    // GET ALL SUBSEQUENCES ==============================================================
    public static ArrayList<String> getSubsequences(String str){
        if(str.equals("")){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        char firstChar = str.charAt(0);
        String smallerString = str.substring(1);

        ArrayList<String> smallerAns = getSubsequences(smallerString); // {}

        ArrayList<String> ans = new ArrayList<>();

        for(String s: smallerAns){ // first character said "no"
            ans.add(s);
        }

        for(String s: smallerAns){ // first character said "yes"
            ans.add(firstChar + s);
        }

        return ans;
    }

    public static void main(String[] args){
        String str = "789";

        ArrayList<String> allSubs = getMazePaths(0,0,3,3);

        System.out.println(allSubs);
    }
}
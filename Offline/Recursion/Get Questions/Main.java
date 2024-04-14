import java.util.ArrayList;
class Main {
    public static ArrayList<String> getMazePathsWithJumps(int i, int j, int n, int m){
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

        // horizontal jumps
        for(int jump=1; jump<m; jump++){
            ArrayList<String> hpaths = getMazePathsWithJumps(i, j+jump, n, m);

            for(String path: hpaths){
                allPaths.add("h"+ jump + path);
            }
        }

        // vertical jumps
        for(int jump=1; jump<n; jump++){
            ArrayList<String> vpaths = getMazePathsWithJumps(i+jump, j, n, m);

            for(String path: vpaths){
                allPaths.add("v"+ jump + path);
            }
        }

        for(int jump=1; jump<Math.min(n,m); jump++){
            ArrayList<String> dpaths = getMazePathsWithJumps(i+jump, j+jump, n, m);

            for(String path: dpaths){
                allPaths.add("d"+ jump + path);
            }
        }

        return allPaths;
    }

    public static ArrayList<String> getMazePathswithDiagonalMove(int i, int j, int n, int m){
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
        ArrayList<String> hpaths = getMazePathswithDiagonalMove(i, j+1, n, m); // {hv, vh, d}

        for(String path: hpaths){ // {hv, vh, d}
            allPaths.add("h" + path); //{hhv, hvh, hd}
        }

        ArrayList<String> vpaths = getMazePathswithDiagonalMove(i+1, j, n, m); // {hh}
        for(String path: vpaths){
            allPaths.add("v" + path); //{hhv, hvh, hd, vhh}
        }

        ArrayList<String> dpaths = getMazePathswithDiagonalMove(i+1, j + 1, n, m); // {h}
        for(String path: dpaths){
            allPaths.add("d" + path); // {hhv, hvh, hd, vhh, dh}
        }

        return allPaths;
    }
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

        ArrayList<String> allSubs = getMazePathsWithJumps(0,0,1,3);

        System.out.println(allSubs);
    }
}
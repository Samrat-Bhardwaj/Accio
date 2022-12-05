import java.util.ArrayList;

public class Main {
    // get all the subsequences
    public static ArrayList<String> getSubsequences(String str){
        if(str.length()==0){
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }

        char first_char = str.charAt(0);
        String ss = str.substring(1); // small string 

        ArrayList<String> sAns = getSubsequences(ss); // faith 

        ArrayList<String> ans = new ArrayList<>();

        // copy from sAns
        for(int i=0; i<sAns.size(); i++){
            String sub = sAns.get(i);
            ans.add(sub);
        }

        // add first char to every sAns element 
        for(int i=0; i<sAns.size(); i++){
            String sub = sAns.get(i);
            String ansSub = first_char + sub;
            ans.add(ansSub);
        }

        return ans;
    }

    // nth even fibonacci number 
    public static int evenFib(int n){
        if(n==0){
            return 0;
        }

        if(n==1){
            return 2;
        }
        
        int ans = 4*evenFib(n-1) + evenFib(n-2);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> subs = getSubsequences("abc");
        System.out.println(subs);
    }
}

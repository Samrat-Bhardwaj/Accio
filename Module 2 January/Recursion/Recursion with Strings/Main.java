import java.util.ArrayList;

public class Main {
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
        String str = "abc";
        ArrayList<String> subs = getSS(str);
        System.out.println(subs);
    }    
}
